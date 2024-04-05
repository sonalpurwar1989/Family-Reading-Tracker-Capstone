package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @RequestMapping(path = "/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer id) {
        Book book = bookDao.getBookById(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        return book;
    }

    @RequestMapping(path = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody Book book) {
        bookDao.saveBook(book);
    }

    @RequestMapping(path = "/books/{id}", method = RequestMethod.PUT)
    public void updateBook(@PathVariable Integer id, @Valid @RequestBody Book book) {
        Book existingBook = bookDao.getBookById(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        book.setId(id);
        bookDao.updateBook(book);
    }

    @RequestMapping(path = "/books/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        Book existingBook = bookDao.getBookById(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        bookDao.deleteBookById(id);
    }
}
