package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.ReadingSession;
import com.techelevator.model.User;
import com.techelevator.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcReadingSessionDao implements ReadingSessionDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcReadingSessionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public ReadingSession findById(Integer id) {
        ReadingSession session = null;
        String sql = "SELECT * FROM reading_sessions WHERE session_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                session = mapRowToReadingSession(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return session;
    }
    @Override
    public void save(ReadingSession session) {
        String sql = "INSERT INTO reading_sessions (user_id, duration_minutes, session_date) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, session.getUser().getId(),
                    session.getDurationMinutes(),
                    session.getSessionDate());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to save the reading session", e);
        }
    }
    @Override
    public void update(ReadingSession session) {
        String sql = "UPDATE reading_sessions SET user_id = ?, " +
                "duration_minutes = ?, session_date = ? WHERE session_id = ?";
        try {
            jdbcTemplate.update(sql, session.getUser().getId(), session.getBook().getId(),
                    session.getReadingFormat(), session.getDurationMinutes(), session.getNotes(),
                    session.getSessionDate(), session.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to update the reading session", e);
        }
    }
    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM reading_sessions WHERE session_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to delete the reading session", e);
        }
    }
    @Override
    public List<ReadingSession> findAll() {
        List<ReadingSession> sessions = new ArrayList<>();
        String sql = "SELECT * FROM reading_sessions";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                sessions.add(mapRowToReadingSession(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return sessions;
    }
    private ReadingSession mapRowToReadingSession(SqlRowSet rs) {
        ReadingSession session = new ReadingSession();
        session.setId(rs.getInt("session_id"));
        User user = new User();
        user.setId(rs.getInt("user_id"));
        session.setUser(user);

        session.setDurationMinutes(rs.getInt("duration_minutes"));

        session.setSessionDate(rs.getTimestamp("session_date").toLocalDateTime());
        return session;
    }
}

















