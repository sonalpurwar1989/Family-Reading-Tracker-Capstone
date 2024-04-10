package com.techelevator.dao;


import com.techelevator.model.Progress;

import java.util.List;

public interface ProgressDao {
    void saveProgress(Progress progress);

    List<Progress> getProgressByUserId(int userId);

}
