package com.techelevator.model;

public class Prize {
    private Integer id;
    private String name;
    private String description;
    private Milestone milestone;

    public Prize() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public Prize(Integer id, String name, String description, Milestone milestone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.milestone = milestone;


    }

}
