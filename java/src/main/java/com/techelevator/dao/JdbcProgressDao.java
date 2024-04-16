package com.techelevator.dao;
import com.techelevator.model.Progress;
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
    public void saveProgress(Progress progress) {
        String sql = "INSERT INTO progress (user_id, book_id, format, duration_minutes, notes) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, progress.getId(), progress.getBook(), progress.getReadingFormat(),
                progress.getDurationMinutes(), progress.getNotes());
    }
    public void update(Progress progress){
        String sql = "UPDATE progress SET user_id = ?, book_id = ?, reading_format = ?, duration_minutes = ?, notes = ? WHERE progress_id = ?";
        jdbcTemplate.update(sql, progress.getUser().getId(), progress.getBook(),
                progress.getReadingFormat(), progress.getDurationMinutes(), progress.getNotes(), progress.getId());
    }
    public List<Progress> getProgressByUserId(int userId) {
        String sql = "SELECT * FROM progress WHERE user_id = ?";
        return jdbcTemplate.query(sql, new ProgressMapper(), userId);
    }
    private static final class ProgressMapper implements RowMapper<Progress> {
        @Override
        public Progress mapRow(ResultSet rs, int rowNum) throws SQLException {
            Progress progress = new Progress();
            progress.setId(rs.getInt("user_id"));
            progress.setBook(rs.getInt("book_id"));
            progress.setReadingFormat(rs.getString("format"));
            progress.setDurationMinutes(rs.getInt("duration_minutes"));
            progress.setNotes(rs.getString("notes"));
            return progress;
        }
    }
}









