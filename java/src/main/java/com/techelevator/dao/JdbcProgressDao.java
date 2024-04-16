package com.techelevator.dao;
import com.techelevator.model.Progress;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class JdbcProgressDao implements ProgressDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcProgressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void saveProgress(Progress progress) {
        String sql = "INSERT INTO progress (user_id, book_id, reading_format, duration_minutes, notes) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, progress.getUser().getId(), progress.getBook(), progress.getReadingFormat(),
                progress.getDurationMinutes(), progress.getNotes());
    }
    @Override
    public void update(Progress progress) {
        String sql = "UPDATE progress SET user_id = ?, book_id = ?, reading_format = ?, duration_minutes = ?, notes = ? WHERE progress_id = ?";
        jdbcTemplate.update(sql, progress.getUser().getId(), progress.getBook(),
                progress.getReadingFormat(), progress.getDurationMinutes(), progress.getNotes(), progress.getId());
    }
    @Override
    public List<Progress> getProgressByUserId(int userId) {
        String sql = "SELECT * FROM progress WHERE user_id = ?";
        return jdbcTemplate.query(sql, new ProgressMapper(), userId);
    }
    @Override
    public Progress findById(int id) {
        String sql = "SELECT * FROM progress WHERE progress_id = ?";
        return jdbcTemplate.queryForObject(sql, new ProgressMapper(), id);
    }

    @Override
    public List<Progress> findAll() {
        String sql = "SELECT * FROM progress";
        return jdbcTemplate.query(sql, new ProgressMapper());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM progress WHERE progress_id = ?";
        jdbcTemplate.update(sql, id);
    }
    private static final class ProgressMapper implements RowMapper<Progress> {
        @Override
        public Progress mapRow(ResultSet rs, int rowNum) throws SQLException {
            Progress progress = new Progress();
            progress.setId(rs.getInt("progress_id"));
            progress.setUser(mapRowToUser(rs));
            progress.setBook(rs.getInt("book_id"));
            progress.setReadingFormat(rs.getString("reading_format"));
            progress.setDurationMinutes(rs.getInt("duration_minutes"));
            progress.setNotes(rs.getString("notes"));
            return progress;
        }
        private User mapRowToUser(ResultSet rs) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            return user;
        }
    }
}


















