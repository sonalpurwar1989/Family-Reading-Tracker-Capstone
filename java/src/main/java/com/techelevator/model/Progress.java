package com.techelevator.model;
import java.time.LocalDate;
public class Progress {
    private Integer id;
    private User user;
    private int book;
    private String readingFormat;
    private Integer durationMinutes;
    private String notes;
    private LocalDate completionDate;
    public Progress() {

    }
    public Progress(Integer id, User user, Book book, String readingFormat, Integer durationMinutes, String notes, LocalDate completionDate) {
        this.id = id;
        this.user = user;
        this.book = book.getId();
        this.readingFormat = readingFormat;
        this.durationMinutes = durationMinutes;
        this.notes = notes;
        this.completionDate = completionDate;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getBook() {
        return book;
    }
    public void setBook(int book) {
        this.book = book;
    }
    public String getReadingFormat() {
        return readingFormat;
    }
    public void setReadingFormat(String readingFormat) {
        this.readingFormat = readingFormat;
    }
    public Integer getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public LocalDate getCompletionDate() {
        return completionDate;
    }
    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}













