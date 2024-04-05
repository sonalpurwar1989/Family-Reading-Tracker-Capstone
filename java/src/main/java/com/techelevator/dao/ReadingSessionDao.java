package com.techelevator.dao;

import com.techelevator.model.ReadingSession;


import java.util.List;

public interface ReadingSessionDao {
    ReadingSession findById(Integer id);
    List<ReadingSession> findAll();
    void save(ReadingSession readingSession);
    void update(ReadingSession readingSession);
    void deleteById(Integer id);

}
