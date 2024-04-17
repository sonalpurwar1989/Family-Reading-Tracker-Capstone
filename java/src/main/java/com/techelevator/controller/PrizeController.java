package com.techelevator.controller;

import com.techelevator.model.Prize;
import com.techelevator.services.PrizeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/prizes")
public class PrizeController {
    private final PrizeService prizeService;

    public PrizeController(PrizeService prizeService, PrizeService prizeService1) {
        this.prizeService = prizeService;

    }

    @GetMapping
    public List<Prize> getAllPrizes() {
        return prizeService.getAllPrizes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPrize(@Valid @RequestBody Prize prize) {
        prizeService.createPrize(prize);
    }

    @PutMapping("/{prizeId}")
    public void updatePrize(@PathVariable Integer prizeId, @Valid @RequestBody Prize prize) {
        prizeService.updatePrize(prizeId, prize);
    }

    @DeleteMapping("/{prizeId}")
    public void deletePrize(@PathVariable Integer prizeId) {
        prizeService.deletePrize(prizeId);
    }
}
















