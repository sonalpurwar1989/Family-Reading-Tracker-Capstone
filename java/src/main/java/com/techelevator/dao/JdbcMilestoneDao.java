
package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Milestone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMilestoneDao implements MilestoneDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMilestoneDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Milestone findById(Integer id) {
        Milestone milestone = null;
        String sql = "SELECT * FROM reading_milestones WHERE milestone_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                milestone = mapRowToMilestone(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return milestone;
    }

    @Override
    public void save(Milestone milestone) {
        String sql = "INSERT INTO reading_milestones (name, description, minutes_required, max_prizes, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(sql, milestone.getName(), milestone.getDescription(), milestone.getMinutesRequired(),
                    milestone.getMaxPrizes(), milestone.getStartDate(), milestone.getEndDate());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to save the milestone", e);
        }
    }

    @Override
    public void update(Milestone milestone) {
        String sql = "UPDATE reading_milestones SET name = ?, description = ?, minutes_required = ?, " +
                "max_prizes = ?, start_date = ?, end_date = ? WHERE milestone_id = ?";
        try {
            jdbcTemplate.update(sql, milestone.getName(), milestone.getDescription(), milestone.getMinutesRequired(),
                    milestone.getMaxPrizes(), milestone.getStartDate(), milestone.getEndDate(), milestone.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to update the milestone", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM reading_milestones WHERE milestone_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to delete the milestone", e);
        }
    }

    @Override
    public List<Milestone> findAll() {
        List<Milestone> milestones = new ArrayList<>();
        String sql = "SELECT * FROM reading_milestones";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                milestones.add(mapRowToMilestone(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return milestones;
    }

    private Milestone mapRowToMilestone(SqlRowSet rs) {
        Milestone milestone = new Milestone();
        milestone.setId(rs.getInt("milestone_id"));
        milestone.setName(rs.getString("name"));
        milestone.setDescription(rs.getString("description"));
        milestone.setMinutesRequired(rs.getInt("minutes_required"));
        milestone.setMaxPrizes(rs.getInt("max_prizes"));
        milestone.setStartDate(rs.getDate("start_date").toLocalDate());
        milestone.setEndDate(rs.getDate("end_date").toLocalDate());
        return milestone;
    }
}









