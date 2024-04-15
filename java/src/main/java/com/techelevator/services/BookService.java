package com.techelevator.services;

import com.techelevator.model.Book;
import com.techelevator.model.BookDetails;
import com.techelevator.model.SearchResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String OPEN_LIBRARY_API_URL = "https://openlibrary.org/isbn/";
    private static final String OPEN_LIBRARY_SEARCH_URL = "https://openlibrary.org/search.json";
    private String authToken = null;

    public BookService() {
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Book getBookByISBN(String isbn) {
        String apiUrl = OPEN_LIBRARY_API_URL + isbn + ".json";
        try {
            SearchResult isr = restTemplate.getForObject(apiUrl, SearchResult.class);
            isr.setSearchISBN(isbn);
            return mapSearchResultToBook(isr);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> searchBooksByTitle(String title) {
        String searchUrl = OPEN_LIBRARY_SEARCH_URL + "?title=" + title.replace(" ", "+");

        List<Book> intermediateList = new ArrayList<>();

        try {
            ResponseEntity<SearchResult> response = restTemplate.getForEntity(searchUrl, SearchResult.class);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                intermediateList = response.getBody().getDocs().stream()
                        .map(this::mapBookDetailsToBook)
                        .collect(Collectors.toList());
            }

            return intermediateList.stream().filter( book -> book.getIsbn().startsWith("978")).collect(Collectors.toList());

        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Book mapSearchResultToBook(SearchResult sr) {
        Book foundBook = new Book();
        foundBook.setTitle(sr.getTitle());
        foundBook.setIsbn(sr.getSearchISBN());
        foundBook.setAuthor(""); // Assuming the API does not provide author information here
        foundBook.setCoverURL("https://covers.openlibrary.org/b/isbn/" + sr.getSearchISBN().trim() + "-M.jpg");
        return foundBook;
    }

    private Book mapBookDetailsToBook(BookDetails details) {

        String defaultISBN = chooseAppropriateIsbn(details.getIsbn());

        Book book = new Book();
        book.setTitle(details.getTitle());
        book.setIsbn(defaultISBN);
        book.setAuthor(details.getAuthor());
        book.setCoverURL("https://covers.openlibrary.org/b/isbn/" + defaultISBN + "-M.jpg");
        book.setNumberOfPages(details.getNumberOfPages());
        return book;
    }

    private String chooseAppropriateIsbn(String[] isbns) {
        if (isbns != null && isbns.length > 0) {
            return isbns[0]; // Simply chooses the first ISBN for simplicity
        }
        return "";
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}







