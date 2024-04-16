package com.techelevator.services;
import com.techelevator.dao.ReadingSessionDao;
import com.techelevator.model.Progress;
import com.techelevator.model.ReadingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ReadingSessionService {
    private final ReadingSessionDao readingSessionDao;
    private final ProgressService progressService;  // Use ProgressService instead of ProgressDao Best for separation of logic
    @Autowired
    public ReadingSessionService(ReadingSessionDao readingSessionDao, ProgressService progressService) {
        this.readingSessionDao = readingSessionDao;
        this.progressService = progressService;  // Inject  newly created ProgressService
    }
    public List<ReadingSession> getAllReadingSessions() {
        return readingSessionDao.findAll();
    }
    public ReadingSession getReadingSessionById(Integer id) {
        return readingSessionDao.findById(id);
    }
    public void recordAndUpdateReadingSession(ReadingSession readingSession) {
        readingSessionDao.save(readingSession);
        updateProgress(readingSession);
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
    private void updateProgress(ReadingSession readingSession){
        List<Progress> progressList = progressService.getProgressByUserId(readingSession.getUser().getId());
        if (!progressList.isEmpty()) {
            Progress progress = progressList.get(0);
            progress.setDurationMinutes(progress.getDurationMinutes() + readingSession.getDurationMinutes());
            progressService.updateProgress(progress);
        } else {
            Progress newProgress = new Progress();
            newProgress.setUser(readingSession.getUser());
            newProgress.setBook(readingSession.getBook().getId());
            newProgress.setReadingFormat(readingSession.getReadingFormat());
            newProgress.setDurationMinutes(readingSession.getDurationMinutes());
            newProgress.setNotes("Initial reading progress");
            progressService.createProgress(newProgress);
        }
    }
}









