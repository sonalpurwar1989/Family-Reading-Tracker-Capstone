package com.techelevator.dao;

import com.techelevator.model.Family;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcFamilyDao implements FamilyDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addFamily(Family family) {
        String sql = "INSERT INTO family (name) VALUES (?)";
        jdbcTemplate.update(sql, family.getFamilyName());
    }




    @Override
    public List<Family> getAllFamilies() {
        String sql = "SELECT * FROM family";
        return jdbcTemplate.query(sql, new FamilyRowMapper());
    }

    @Override
    public Family getFamilyById(Integer familyId) {
        String sql = "SELECT * FROM family WHERE family_id = ?";
        return jdbcTemplate.queryForObject(sql, new FamilyRowMapper(), familyId);
    }

    @Override
    public void updateFamily(Family family) {
        String sql = "UPDATE family SET name = ? WHERE family_id = ?";
        jdbcTemplate.update(sql, family.getFamilyName(), family.getFamilyId());
    }

    @Override
    public void deleteFamily(Integer familyId) {
        String sql = "DELETE FROM family WHERE family_id = ?";
        jdbcTemplate.update(sql, familyId);
    }

    @Override
    public List<Family> getAllFamiliesWithQueryForRowSet() {
        String sql = "SELECT * FROM family";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        List<Family> families = new ArrayList<>();
        while (rowSet.next()) {
            Family family = new Family();
            family.setFamilyId(rowSet.getInt("family_id"));
            family.setFamilyName(rowSet.getString("name"));
            families.add(family);
        }
        return families;
    }

    private static class FamilyRowMapper implements RowMapper<Family> {
        @Override
        public Family mapRow(ResultSet rs, int rowNum) throws SQLException {
            Family family = new Family();
            family.setFamilyId(rs.getInt("family_id"));
            family.setFamilyName(rs.getString("name"));
            return family;
        }
    }


}
