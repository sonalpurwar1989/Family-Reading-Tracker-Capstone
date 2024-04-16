package com.techelevator.services;
import com.techelevator.dao.ProgressDao;
import com.techelevator.model.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProgressService {
    private final ProgressDao progressDao;
    @Autowired
    public ProgressService(ProgressDao progressDao) {
        this.progressDao = progressDao;
    }
    public List<Progress> getAllProgress() {
        return progressDao.findAll();
    }
    public Progress getProgressById(int id) {
        return progressDao.findById(id);
    }
    public Progress createProgress(Progress progress) {
        progressDao.saveProgress(progress);
        return progress;  // Return the progress after saving it
    }
    public Progress updateProgress(Progress progress) {
        progressDao.update(progress);
        return progress;  // Return the updated progress
    }
    public boolean deleteProgress(int id) {
        try {
            progressDao.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
    public List<Progress> getProgressByUserId(int userId) {
        return progressDao.getProgressByUserId(userId);
    }
}







