package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Prize;
import com.techelevator.model.Milestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPrizeDao implements PrizeDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcPrizeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Prize findById(Integer id) {
        Prize prize = null;
        String sql = "SELECT * FROM prizes WHERE prize_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                prize = mapRowToPrize(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return prize;
    }
    @Override
    public void save(Prize prize) {
        String sql = "INSERT INTO prizes (milestone_id, name, description) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, prize.getMilestone().getId(), prize.getName(), prize.getDescription());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to save the prize", e);
        }
    }
    @Override
    public void update(Prize prize) {
        String sql = "UPDATE prizes SET milestone_id = ?, name = ?, description = ? WHERE prize_id = ?";
        try {
            jdbcTemplate.update(sql, prize.getMilestone().getId(), prize.getName(), prize.getDescription(), prize.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to update the prize", e);
        }
    }
    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM prizes WHERE prize_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to delete the prize", e);
        }
    }
    @Override
    public List<Prize> findAll() {
        List<Prize> prizes = new ArrayList<>();
        String sql = "SELECT * FROM prizes";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                prizes.add(mapRowToPrize(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return prizes;
    }
    private Prize mapRowToPrize(SqlRowSet rs) {
        Prize prize = new Prize();
        prize.setId(rs.getInt("prize_id"));
        Milestone milestone = new Milestone();
        milestone.setId(rs.getInt("milestone_id"));
        prize.setMilestone(milestone);
        prize.setName(rs.getString("name"));
        prize.setDescription(rs.getString("description"));
        return prize;
    }
}





















