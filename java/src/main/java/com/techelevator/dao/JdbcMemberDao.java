package com.techelevator.dao;

import com.techelevator.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMemberDao implements MemberDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Member> getAllMembers() {
        String sql = "SELECT * FROM member";
        return jdbcTemplate.query(sql, new MemberRowMapper());
    }
    @Override
    public List<Member> getMembersByFamilyId(int familyId) {
        String sql = "SELECT m.* FROM member m " +
                "INNER JOIN family f ON m.family_id = f.family_id " +
                "WHERE f.family_id = ?";
        return jdbcTemplate.query(sql, new MemberRowMapper(), familyId);
    }
    @Override
    public Member getMemberById(int memberId) {
        String sql = "SELECT * FROM member WHERE member_id = ?";
        return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), memberId);
    }

    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO member (family_id, member_name, member_type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, member.getFamilyId(), member.getMemberName(), member.getMemberType());
    }

    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE member SET family_id = ?, member_name = ?, member_type = ? WHERE member_id = ?";
        jdbcTemplate.update(sql, member.getFamilyId(), member.getMemberName(), member.getMemberType(), member.getMemberId());
    }

    @Override
    public void deleteMember(int memberId) {
        String sql = "DELETE FROM member WHERE member_id = ?";
        jdbcTemplate.update(sql, memberId);
    }

    private static class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();
            member.setMemberId(rs.getInt("member_id"));
            member.setFamilyId(rs.getInt("family_id"));
            member.setMemberName(rs.getString("member_name"));
            member.setMemberType(rs.getString("member_type"));
            return member;
        }
    }
}
