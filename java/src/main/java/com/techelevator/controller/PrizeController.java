package com.techelevator.controller;



        import com.techelevator.dao.PrizeDao;
        import com.techelevator.model.Prize;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;
        import javax.validation.Valid;
        import java.util.List;
@RestController
@RequestMapping("/prizes")
public class PrizeController {
    private final PrizeDao prizeDao;
    public PrizeController(PrizeDao prizeDao) {
        this.prizeDao = prizeDao;
    }
    @GetMapping
    public List<Prize> getAllPrizes() {
        return prizeDao.getAllPrizes();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPrize(@Valid @RequestBody Prize prize) {
        prizeDao.createPrize(prize);
    }
    @PutMapping("/{prizeId}")
    public void updatePrize(@PathVariable int prizeId, @Valid @RequestBody Prize prize) {
        prize.setId(prizeId);
        prizeDao.updatePrize(prize);
    }
    @DeleteMapping("/{prizeId}")
    public void deletePrize(@PathVariable int prizeId) {
        prizeDao.deletePrizeById(prizeId);
    }
}








