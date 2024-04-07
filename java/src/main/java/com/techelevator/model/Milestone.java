package com.techelevator.model;

import java.time.LocalDate;

public class Milestone {

    private Integer id;
    private String name;
    private String description;
    private Integer minutesRequired;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxPrizes;

    public Milestone() {

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

    public Integer getMinutesRequired() {
        return minutesRequired;
    }

    public void setMinutesRequired(Integer minutesRequired) {
        this.minutesRequired = minutesRequired;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxPrizes() {
        return maxPrizes;
    }

    public void setMaxPrizes(Integer maxPrizes) {
        this.maxPrizes = maxPrizes;
    }

    public Milestone(Integer id, String name, String description, Integer minutesRequired, LocalDate startDate, LocalDate endDate, Integer maxPrizes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minutesRequired = minutesRequired;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxPrizes = maxPrizes;


    }
}
