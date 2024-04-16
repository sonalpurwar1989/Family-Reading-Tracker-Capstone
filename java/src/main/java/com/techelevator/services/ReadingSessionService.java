package com.techelevator.services;
import com.techelevator.dao.ProgressDao;
import com.techelevator.dao.ReadingSessionDao;
import com.techelevator.model.Progress;
import com.techelevator.model.ReadingSession;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class ReadingSessionService {
    private final ReadingSessionDao readingSessionDao;

    private ProgressDao progressDao;




    @Autowired
    public ReadingSessionService(ReadingSessionDao readingSessionDao, ProgressDao progressDao) {
        this.readingSessionDao = readingSessionDao;
        this.progressDao = progressDao;

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

    public void updateProgress(ReadingSession readingSession){
        List<Progress> progressList= progressDao.getProgressByUserId(readingSession.getUser().getId());
        if(!progressList.isEmpty()){
            Progress progress = progressList.get(0);
            progress.setDurationMinutes(progress.getDurationMinutes() + readingSession.getDurationMinutes());
            progressDao.update(progress);
        }else{
            Progress newProgress = new Progress();
            newProgress.setUser(readingSession.getUser());
            newProgress.setBook(readingSession.getBook().getId());
            newProgress.setReadingFormat(readingSession.getReadingFormat());
            newProgress.setDurationMinutes(readingSession.getDurationMinutes());
            newProgress.setNotes("Initial reading progress");
            progressDao.saveProgress(newProgress);
        }
    }
}
