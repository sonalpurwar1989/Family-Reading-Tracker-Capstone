package com.techelevator.dao;

import com.techelevator.model.User;

import com.techelevator.model.Book;
import java.util.List;

public interface BookDao {

    Book getBookById(Integer id);

    List<Book> getAllBooks();

    void deleteBookById(Integer id);

    void updateBook(Book book);

    void saveBook(Book book);



}
