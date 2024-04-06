package com.techelevator.model;

public class Family {

    private Integer familyId;
    private String familyName;

    public Family(Integer familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }
    public Family(){};
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
