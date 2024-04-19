package solva.solvaTestProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solva.solvaTestProject.dto.LimitDto;
import solva.solvaTestProject.entity.Limits;
import solva.solvaTestProject.repository.LimitRepository;
import solva.solvaTestProject.repository.TransactionsRepository;

import java.time.ZonedDateTime;

@Service
public class LimitService {
    @Autowired
    private LimitRepository limitRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public void setLimit(LimitDto limitDto) {
        Limits limits = new Limits();
        int accountId = limitDto.getAccountId();
        ZonedDateTime localDate = ZonedDateTime.now();
        ZonedDateTime beforeDate = localDate.minusMonths(1);
        Double allAmounts = transactionsRepository.findByIdAndTransactionAmount(accountId, localDate, beforeDate);
        double limitBalance;
        if (limitDto.getLimit() == 0) {
            limitBalance = 1000;
        } else {
            limitBalance = limitDto.getLimit();
        }

        limitBalance = limitBalance - allAmounts;
        limits.setLimitBalance(limitBalance);

        String currencyShortname = limitDto.getCurrencyShortname();
        limits.setAccountId(accountId);
        limits.setCurrencyShortname(currencyShortname);
        limits.setLimitDate(localDate);
        limits.setLimitBalance(limitBalance);
        limitRepository.save(limits);
    }

}
