package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.List;

public interface PrizeDao {
    Prize findById(Integer id);

    void save(Prize prize);

    void update(Prize prize);

    void deleteById(Integer id);

    List<Prize> findAll();

    void deletePrizeById(int prizeId);

    void updatePrize(Prize prize);

    void createPrize(Prize prize);

    List<Prize> getAllPrizes();
}