package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Book;
import com.techelevator.model.ReadingSession;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcReadingSessionDao implements ReadingSessionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcReadingSessionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //private RowMapper<ReadingSession> rowMapper = ((rs, rowNum) -> {
    private class ReadingSessionMapper implements RowMapper<ReadingSession> {
        public ReadingSession mapRow(ResultSet rs, int rowNum) throws SQLException {
            ReadingSession session = new ReadingSession();
            User user = new User();
            user.setId(rs.getInt("user_id"));
            session.setUser(user);
            Book book = new Book();
            book.setId(rs.getInt("book_id"));
            session.setBook(book);
            session.setReadingFormat(rs.getString("reading_format"));
            session.setDurationMinutes(rs.getInt("duration_minutes"));
            session.setNotes(rs.getString("notes"));
            session.setSessionDate(rs.getTimestamp("session_date").toLocalDateTime());
            return session;

        }

        ;

        /* @Override
         public ReadingSession findById(Integer id){
             String sql = "SELECT * FROM reading_sessions WHERE id = ?";
             return jdbcTemplate.queryForObject(sql, new Object[]{id}, RowMapper);
         }
         }
     */
  /*  @Override
    public ReadingSession findById(Integer id) {
        ReadingSession readingSession = null;
        String sql = "SELECT session_id FROM reading_sessions WHERE session_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                readingSession = mapRowToReadingSession(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return readingSession;
    }*/
        }

    @Override
    public ReadingSession findById(Integer id) {
        String sql = "SELECT * FROM reading_sessions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ReadingSessionMapper());

    }

    @Override
    public List<ReadingSession> findAll() {
        String sql = "SELECT * FROM reading_sessions";
        return jdbcTemplate.query(sql, new ReadingSessionMapper());
    }

    @Override
    public void save(ReadingSession readingSession) {
        String sql = "INSERT INTO reading_sessions(usr_id, book_id, reading_format,duration_minutes, notes, session_date) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                readingSession.getUser().getId(),
                readingSession.getBook().getId(),
                readingSession.getReadingFormat(),
                readingSession.getDurationMinutes(),
                readingSession.getNotes(),
                readingSession.getSessionDate());
    }

    @Override
    public void update(ReadingSession readingSession) {
        String sql = "UPDATE reading_sessions SET user_id = ?, book_id = ?, duration_minutes = ?, notes = ?, sessions_date = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                readingSession.getUser().getId(),
                readingSession.getBook().getId(),
                readingSession.getReadingFormat(),
                readingSession.getDurationMinutes(),
                readingSession.getNotes(),
                readingSession.getSessionDate(),
                readingSession.getId());

    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM reading_sessions WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }
}