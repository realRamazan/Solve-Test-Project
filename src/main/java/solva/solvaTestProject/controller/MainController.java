package solva.solvaTestProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solva.solvaTestProject.dto.ExchangeRateDto;
import solva.solvaTestProject.dto.LimitDto;
import solva.solvaTestProject.entity.Transactions;
import solva.solvaTestProject.repository.TransactionsRepository;
import solva.solvaTestProject.service.ExchangeService;
import solva.solvaTestProject.service.LimitService;
import solva.solvaTestProject.service.TransactionsService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private LimitService limitService;

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping("/setLimit")
    public void setLimit(@RequestBody LimitDto limitDto){
        limitService.setLimit(limitDto);
    }

    @GetMapping("/exceeded")
    public List<Transactions> getExceededTransactions(@RequestParam("id") int accountId){
        return transactionsService.getExceededTransactions(accountId);
    }

    @GetMapping("/rates")
    public ExchangeRateDto getRates(@RequestParam("symbol") String symbol){
        return exchangeService.getRates(symbol);
    }


    @PostMapping("/spend")
    public void spend(@RequestParam("id") int accountId,
                      @RequestParam("amount") double amount,
                      @RequestParam("type") String type) {
        transactionsService.spend(accountId, amount, type);
    }
}
