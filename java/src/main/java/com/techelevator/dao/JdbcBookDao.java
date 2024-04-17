


package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;
    private final JdbcUserDao jdbcUserDao;

    @Autowired
    public JdbcBookDao(JdbcTemplate jdbcTemplate, JdbcUserDao jdbcUserDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcUserDao = jdbcUserDao;
    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM book WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookMapper());
    }

    @Override
    public List<Book> getBooksByUserId(Integer id) {
        String sql = "SELECT b.* FROM book b INNER JOIN users_book bu ON bu.book_id = b.book_id WHERE bu.user_id = ?;";
        return jdbcTemplate.query(sql, new BookMapper());

    }


    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BookMapper());
    }

    @Override
    public void deleteBookById(Integer id) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        jdbcTemplate.update(sql, id);
    }


    public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, isbn = ? WHERE book_id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getIsbn(), book.getId());
    }

    public void saveBook(Book book, String username) {
        String bookSql = "INSERT INTO book (title, author, isbn) VALUES (?, ?, ?) RETURNING book_id";
        Integer newBook_id = jdbcTemplate.queryForObject(bookSql, Integer.class, book.getTitle(), book.getAuthor(), book.getIsbn());

        String usersBookSql = "INSERT INTO users_book (user_id, book_id) VALUES(?, ?)";

        int user_id =  jdbcUserDao.getUserByUsername(username).getId();

        jdbcTemplate.update(usersBookSql, user_id, newBook_id);

    }

    @Override
    public Book getBookByISBN(String isbn) {
        String sql = "SELECT * FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{isbn}, new BookMapper());
    }

    private static final class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("book_id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setIsbn(rs.getString("isbn"));
            book.setCoverURL("https://covers.openlibrary.org/b/isbn/" + rs.getString("isbn") + "-M.jpg");
            return book;
        }
    }
}

