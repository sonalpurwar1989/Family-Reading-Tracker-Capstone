package com.techelevator.model;

public class Member {

    private int memberId;
    private int familiyId;
    private String memberName;
    private String memberType; // parent or child

    public Member(int memberId, int familyId, String memberName, String memberType) {
        this.memberId = memberId;
        this.familiyId=  familiyId;
        this.memberName = memberName;
        this.memberType = memberType;
    }
    public Member(){};
    public int getMemberId() {
        return memberId;
    }

    public int getFamilyId() {
        return familiyId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setFamilyId(int familyId) {
        this.familiyId = familyId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberType() {
        return memberType;
    }
}
