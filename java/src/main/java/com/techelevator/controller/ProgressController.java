package com.techelevator.controller;
import com.techelevator.model.Progress;
import com.techelevator.services.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    private final ProgressService progressService;
    @Autowired
    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }
    // Retrieve all progress records
    @GetMapping
    public ResponseEntity<List<Progress>> getAllProgress() {
        List<Progress> progressList = progressService.getAllProgress();
        return new ResponseEntity<>(progressList, HttpStatus.OK);
    }
    // Retrieve a single progress record by ID maybe if a parent wants to see a childs progress
    @GetMapping("/{id}")
    public ResponseEntity<Progress> getProgressById(@PathVariable int id) {
        Progress progress = progressService.getProgressById(id);
        if (progress != null) {
            return new ResponseEntity<>(progress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Create a new progress record
    @PostMapping
    public ResponseEntity<Progress> createProgress(@RequestBody Progress progress) {
        Progress newProgress = progressService.createProgress(progress);
        return new ResponseEntity<>(newProgress, HttpStatus.CREATED);
    }
    // Update a progress record that already exists
    @PutMapping("/{id}")
    public ResponseEntity<Progress> updateProgress(@PathVariable int id, @RequestBody Progress progress) {
        Progress existingProgress = progressService.getProgressById(id);
        if (existingProgress == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        progress.setId(id);
        Progress updatedProgress = progressService.updateProgress(progress);
        return new ResponseEntity<>(updatedProgress, HttpStatus.OK);
    }
    // Delete a progress record if we want that functionality
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable int id) {
        boolean wasDeleted = progressService.deleteProgress(id);
        if (wasDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}









