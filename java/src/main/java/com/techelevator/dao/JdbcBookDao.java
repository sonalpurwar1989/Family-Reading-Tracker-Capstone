


package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookMapper());
    }


    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BookMapper());
    }

    @Override
    public void deleteBookById(Integer id) {
        String sql = "DELETE FROM books WHERE book_id = ?";
        jdbcTemplate.update(sql, id);
    }


    public void updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, author = ?, isbn = ? WHERE book_id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getIsbn(), book.getId());
    }

    public void saveBook(Book book) {
        String sql = "INSERT INTO books (title, author, isbn) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getIsbn());
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
            return book;
        }
    }
}

