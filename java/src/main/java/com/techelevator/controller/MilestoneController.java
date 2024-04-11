

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Milestone> getAllMilestones() {
        return milestoneDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMilestone(@Valid @RequestBody Milestone milestone) {
        milestoneDao.save(milestone);
    }

    @RequestMapping(value = "/{milestoneId}", method = RequestMethod.PUT)
    public void updateMilestone(@PathVariable Integer milestoneId, @Valid @RequestBody Milestone milestone) {
        milestone.setId(milestoneId);
        milestoneDao.update(milestone);
    }

    @RequestMapping(value = "/{milestoneId}", method = RequestMethod.DELETE)
    public void deleteMilestone(@PathVariable Integer milestoneId) {
        milestoneDao.deleteById(milestoneId);
    }
}

















