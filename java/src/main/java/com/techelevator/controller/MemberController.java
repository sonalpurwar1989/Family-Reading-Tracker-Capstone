package com.techelevator.controller;


import com.techelevator.dao.MemberDao;
import com.techelevator.model.Member;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController

    public class MemberController {

        private final MemberDao memberDao;

        public MemberController(MemberDao memberDao) {
            this.memberDao = memberDao;
        }

        @RequestMapping(value = "/members", method = RequestMethod.GET)
        public List<Member> getAllMembers() {
            return memberDao.getAllMembers();
        }

        @RequestMapping(value = "/members/{memberId}", method = RequestMethod.GET)
        public Member getMemberById(@PathVariable int memberId) {
            return memberDao.getMemberById(memberId);
        }

        @RequestMapping(value = "/members", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public void addMember(@Valid @RequestBody Member member) {
            memberDao.addMember(member);
        }

        @RequestMapping(value = "/members/{memberId}", method = RequestMethod.PUT)
        public void updateMember(@PathVariable int memberId, @Valid @RequestBody Member member) {
            if (memberId != member.getMemberId()) {
                throw new IllegalArgumentException("Member ID in path must match member ID in request body");
            }
            memberDao.updateMember(member);
        }

        @RequestMapping(value = "/members/{memberId}", method = RequestMethod.DELETE)
        public void deleteMember(@PathVariable int memberId) {
            memberDao.deleteMember(memberId);
        }
    }



