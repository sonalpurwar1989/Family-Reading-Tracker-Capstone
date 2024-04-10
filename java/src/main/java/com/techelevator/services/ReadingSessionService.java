package com.techelevator.services;
import com.techelevator.dao.ReadingSessionDao;
import com.techelevator.model.ReadingSession;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ReadingSessionService {
    private final ReadingSessionDao readingSessionDao;
    @Autowired
    public ReadingSessionService(ReadingSessionDao readingSessionDao) {
        this.readingSessionDao = readingSessionDao;
    }
    public List<ReadingSession> getAllReadingSessions() {
        return readingSessionDao.findAll();
    }
    public ReadingSession getReadingSessionById(Integer id) {
        return readingSessionDao.findById(id);
    }
    public void createReadingSession(ReadingSession readingSession) {
        readingSessionDao.save(readingSession);
    }
    public void updateReadingSession(Integer id, ReadingSession updatedReadingSession) {
        ReadingSession existingReadingSession = readingSessionDao.findById(id);
        if (existingReadingSession != null) {
            updatedReadingSession.setId(id);
            readingSessionDao.update(updatedReadingSession);
        } else {
            throw new RuntimeException("Reading session not found with id: " + id);
        }
    }
    public void deleteReadingSession(Integer id) {
        ReadingSession existingReadingSession = readingSessionDao.findById(id);
        if (existingReadingSession != null) {
            readingSessionDao.deleteById(id);
        } else {
            throw new RuntimeException("Reading session not found with id: " + id);
        }
    }
    public void recordReadingSession(ReadingSession readingSession) {
        int milestoneMinutes = 300;
        User user = readingSession.getUser();
        user.setMinutesRead(user.getMinutesRead() + readingSession.getDurationMinutes());
        if (user.getMinutesRead() >= milestoneMinutes) {
            System.out.println("Congratulations! You've reached the milestone of 300 minutes!");
            System.out.println("Prize unlocked, Your choice between Ice Cream or Vinyl Sticker");
        }
    }
}













