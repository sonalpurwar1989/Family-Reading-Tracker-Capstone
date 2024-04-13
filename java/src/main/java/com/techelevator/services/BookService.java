package com.techelevator.services;

import com.techelevator.model.Book;
import com.techelevator.model.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class BookService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String OPEN_LIBRARY_API_URL = "https://openlibrary.org/isbn/";
    private static final String OPEN_LIBRARY_COVERS_URL = "https://covers.openlibrary.org/a/olid";
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public BookService() {
     //   this.restTemplate = restTemplate;
    }

    public Book getBookByISBN(String isbn) {
        String apiUrl = OPEN_LIBRARY_API_URL + isbn + ".json";
        try {
            SearchResult isr = restTemplate.getForObject(apiUrl, SearchResult.class);
            isr.setSearchISBN(isbn);
            return mapSearchResultToBook(isbn, isr);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Book mapSearchResultToBook (String isbnSearchValue, SearchResult sr){

        Book foundBook = new Book();

        foundBook.setTitle( sr.getTitle());
        foundBook.setIsbn( sr.getSearchISBN());
        foundBook.setAuthor( "");
        foundBook.setCoverURL( "https://covers.openlibrary.org/b/isbn/" +  isbnSearchValue.trim()+ "-M.jpg" );

        return foundBook;
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);

    }
}


// add method getbookbytitle include getbookbyisbn in my getbookbytitle method,
