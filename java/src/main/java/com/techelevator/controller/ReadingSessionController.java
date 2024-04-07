package com.techelevator.controller;


import com.techelevator.dao.ReadingSessionDao;
import com.techelevator.model.ReadingSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/reading-sessions")
public class ReadingSessionController {
    private final ReadingSessionDao readingSessionDao;

    public ReadingSessionController(ReadingSessionDao readingSessionDao) {
        this.readingSessionDao = readingSessionDao;
    }

    @GetMapping
    public List<ReadingSession> getAllReadingSessions() {
        return readingSessionDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadingSession> getReadingSessionById(@PathVariable Integer id) {
        ReadingSession readingSession = readingSessionDao.findById(id);
        if (readingSession != null) {
            return new ResponseEntity<>(readingSession, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReadingSession(@Valid @RequestBody ReadingSession readingSession) {
        readingSessionDao.save(readingSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReadingSession> updateReadingSession(@PathVariable Integer id, @Valid @RequestBody ReadingSession updatedReadingSession) {
        ReadingSession existingReadingSession = readingSessionDao.findById(id);
        if (existingReadingSession != null) {
            updatedReadingSession.setId(id);
            readingSessionDao.update(updatedReadingSession);
            return new ResponseEntity<>(updatedReadingSession, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReadingSession(@PathVariable Integer id) {
        ReadingSession existingReadingSession = readingSessionDao.findById(id);
        if (existingReadingSession != null) {
            readingSessionDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
