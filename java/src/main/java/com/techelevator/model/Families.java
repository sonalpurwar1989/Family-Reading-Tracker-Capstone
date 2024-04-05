package com.techelevator.model;

public class Families {

    private Integer id;
    private String familyName;

    public Families(Integer id, String familyName) {
        this.id = id;
        this.familyName = familyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
