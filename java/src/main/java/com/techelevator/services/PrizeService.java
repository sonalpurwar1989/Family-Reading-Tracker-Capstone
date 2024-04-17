package com.techelevator.services;

import com.techelevator.dao.PrizeDao;
import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PrizeService {
    private final PrizeDao prizeDao;

    @Autowired
    public PrizeService(PrizeDao prizeDao) {
        this.prizeDao = prizeDao;
    }

    public List<Prize> getAllPrizes() {
        return prizeDao.findAll();
    }

    public void createPrize(Prize prize) {
        prizeDao.save(prize);
    }

    public Prize getPrizeById(Integer id) {
        return prizeDao.findById(id);
    }
    public void updatePrize(Integer prizeId, Prize prize){
        prize.setId(prizeId);
        prizeDao.update(prize);
    }
    public void deletePrize(Integer prizeId){
        prizeDao.deleteById(prizeId);
    }
}

