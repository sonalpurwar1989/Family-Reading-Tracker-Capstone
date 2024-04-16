package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.model.Book;
import com.techelevator.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private final BookDao bookDao;
    private final BookService bookService;

    public BookController(BookDao bookDao, BookService bookService) {
        this.bookDao = bookDao;
        this.bookService = bookService;
    }

    @RequestMapping(path = "/book", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @RequestMapping(path = "/book/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Integer id) {
        Book book = bookDao.getBookById(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        return book;
    }

    @RequestMapping(path = "/book", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody Book book, Principal user) {
        bookDao.saveBook(book, user.getName());
    }

    @RequestMapping(path = "/book/{id}", method = RequestMethod.PUT)
    public void updateBook(@PathVariable Integer id, @Valid @RequestBody Book book) {
        Book existingBook = bookDao.getBookById(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        book.setId(id);
        bookDao.updateBook(book);
    }

    @RequestMapping(path = "/book/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        Book existingBook = bookDao.getBookById(id);
        if (existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        }
        bookDao.deleteBookById(id);
    }


    @RequestMapping(path = "/isbn/{isbn}", method = RequestMethod.GET)
    public Book getBookByISBN(@PathVariable String isbn) {
        String tempISBN = isbn;
        return bookService.getBookByISBN(isbn);
    }

    @RequestMapping(path = "/books/search", method = RequestMethod.GET)
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        try {
            return bookService.searchBooksByTitle(title);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to search book by title", e);
        }
    }
}
