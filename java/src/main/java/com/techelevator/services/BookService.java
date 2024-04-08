package com.techelevator.services;

import com.techelevator.model.Book;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class BookService {
    private final RestTemplate restTemplate;
    private static final String OPEN_LIBRARY_API_URL = "https://openlibrary.org/isbn";
    private static final String OPEN_LIBRARY_COVERS_URL = "https://covers.openlibrary.org/a/olid";
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Book getBookByISBN(String isbn) {
        String apiUrl = OPEN_LIBRARY_API_URL + isbn + ".json";
        try {
            ResponseEntity<Book> response = restTemplate.exchange(apiUrl, HttpMethod.GET, makeAuthEntity(), Book.class);
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);

    }
}
