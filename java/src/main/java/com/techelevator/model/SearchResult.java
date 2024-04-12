package com.techelevator.model;

import java.util.Arrays;
import java.util.Objects;

public class SearchResult {

    private String searchISBN;

    public String getSearchISBN() {
        return searchISBN;
    }

    public void setSearchISBN(String searchISBN) {
        this.searchISBN = searchISBN;
    }

    private String[] publishers;

    private Integer numberOfPages;

    private String[] isbn13;

    private String title;

    public String[] getPublishers() {
        return publishers;
    }

    public void setPublishers(String[] publishers) {
        this.publishers = publishers;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String[] getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String[] isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;
        return Arrays.equals(publishers, that.publishers) && Objects.equals(numberOfPages, that.numberOfPages) && Arrays.equals(isbn13, that.isbn13) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfPages, title);
        result = 31 * result + Arrays.hashCode(publishers);
        result = 31 * result + Arrays.hashCode(isbn13);
        return result;
    }
}
