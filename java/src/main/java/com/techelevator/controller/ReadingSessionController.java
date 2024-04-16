package com.techelevator.controller;

import com.techelevator.model.ReadingSession;
import com.techelevator.services.ReadingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reading-sessions")
public class ReadingSessionController {
    private final ReadingSessionService readingSessionService;

    @Autowired
    public ReadingSessionController(ReadingSessionService readingSessionService) {
        this.readingSessionService = readingSessionService;
    }

    @GetMapping
    public List<ReadingSession> getAllReadingSessions() {
        return readingSessionService.getAllReadingSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingSession> getReadingSessionById(@PathVariable Integer id) {
        ReadingSession readingSession = readingSessionService.getReadingSessionById(id);
        if (readingSession != null) {
            return new ResponseEntity<>(readingSession, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void recordReadingSession(@Valid @RequestBody ReadingSession readingSession) {
        readingSessionService.recordAndUpdateReadingSession(readingSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadingSession> updateReadingSession(@PathVariable Integer id, @Valid @RequestBody ReadingSession updatedReadingSession) {
        ReadingSession existingReadingSession = readingSessionService.getReadingSessionById(id);
        if (existingReadingSession != null) {
            updatedReadingSession.setId(id);
            readingSessionService.updateReadingSession(id, updatedReadingSession);
            return new ResponseEntity<>(updatedReadingSession, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReadingSession(@PathVariable Integer id) {
        ReadingSession existingReadingSession = readingSessionService.getReadingSessionById(id);
        if (existingReadingSession != null) {
            readingSessionService.deleteReadingSession(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}