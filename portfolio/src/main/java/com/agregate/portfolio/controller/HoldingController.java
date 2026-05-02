package com.agregate.portfolio.controller;

import com.agregate.portfolio.entity.Holding;
import com.agregate.portfolio.repository.HoldingRepository;
import com.agregate.portfolio.service.FinnhubService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/holdings")
public class HoldingController {

    private final HoldingRepository holdingRepository;
    private final FinnhubService finnhubService;

    public HoldingController(HoldingRepository holdingRepository, FinnhubService finnhubService) {
        this.holdingRepository = holdingRepository;
        this.finnhubService = finnhubService;
    }

    @GetMapping
    public List<Holding> getAll() {

        List<Holding> holdings = holdingRepository.findAll();
        
        for (Holding holding : holdings) {
        holding.setCurrentPrice(finnhubService.getCurrentPrice(holding.getTicker()));
        }
        return holdings;
    }

    @PostMapping
    public Holding create(@RequestBody Holding holding) {
        return holdingRepository.save(holding);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        holdingRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Holding put(@PathVariable Long id, @RequestBody Holding holding) {
        holding.setId(id);
        return holdingRepository.save(holding); 
    }
}