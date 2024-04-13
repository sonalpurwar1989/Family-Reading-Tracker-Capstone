package com.techelevator.model;

public class BookDetails {
    private String title;
    private String[] isbn;
    private String coverUrl;
    private String author;
    private int numberOfPages;

    // Constructor
    public BookDetails() {
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getIsbn() {
        return isbn;
    }

    public void setIsbn(String[] isbn) {
        this.isbn = isbn;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    // ToString, Equals, and HashCode implementations could be added here as needed
}









