package com.techelevator.dao;


import com.techelevator.model.Member;

import java.util.List;

    public interface MemberDao {

        List<Member> getAllMembers();

        List<Member> getMembersByFamilyId(int familyId);

        Member getMemberById(int memberId);

        void addMember(Member member);

        void updateMember(Member member);

        void deleteMember(int memberId);

    }


