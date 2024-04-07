package com.techelevator.controller;

import com.techelevator.dao.MilestoneDao;
import com.techelevator.model.Milestone;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/milestones")
public class MilestoneController {
    private final MilestoneDao milestoneDao;

    public MilestoneController(MilestoneDao milestoneDao) {
        this.milestoneDao = milestoneDao;
    }

    @GetMapping
    public List<Milestone> getAllMilestones() {
        return milestoneDao.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMilestone(@Valid @RequestBody Milestone milestone) {
        milestoneDao.save(milestone);
    }

    @PutMapping("/{milestoneId}")
    public void updateMilestone(@PathVariable Integer milestoneId, @Valid @RequestBody Milestone milestone) {
        milestone.setId(milestoneId);
        milestoneDao.update(milestone);
    }

    @DeleteMapping("/{milestoneId}")
    public void deleteMilestone(@PathVariable Integer milestoneId) {
        milestoneDao.deleteById(milestoneId);
    }
}



















