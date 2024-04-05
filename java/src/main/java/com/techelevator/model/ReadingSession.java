package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReadingSession {


    private Integer id;
    private User user;
    private Book book;
    private String readingFormat;
    private Integer durationMinutes;
    private String notes;
    private LocalDateTime sessionDate;

    public ReadingSession() {

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
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

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public ReadingSession(Integer id, User user, Book book, String readingFormat, Integer durationMinutes, String notes, LocalDateTime sessionDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.readingFormat = readingFormat;
        this.durationMinutes = durationMinutes;
        this.notes = notes;
        this.sessionDate = sessionDate;


    }
}

