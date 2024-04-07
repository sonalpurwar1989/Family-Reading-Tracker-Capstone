package com.techelevator.dao;

import com.techelevator.model.Milestone;

import java.util.List;

public interface MilestoneDao {
    Milestone findById(Integer id);

    void save(Milestone milestone);

    void update(Milestone milestone);

    void deleteById(Integer id);

    List<Milestone> findAll();

    List<Milestone> getAllMilestones();

    void createMilestone(Milestone milestone);

    void updateMilestone(Milestone milestone);

    void deleteMilestoneById(int milestoneId);
}