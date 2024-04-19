package solva.solvaTestProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solva.solvaTestProject.entity.Transactions;
import solva.solvaTestProject.repository.LimitRepository;
import solva.solvaTestProject.repository.TransactionsRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    LimitRepository limitRepository;

    public List<Transactions> getExceededTransactions(int accountId) {
        ZonedDateTime localDate = ZonedDateTime.now();
        ZonedDateTime beforeDate = localDate.minusMonths(1);
        return transactionsRepository.findByIdAndLimitExceeded(accountId, localDate, beforeDate);
    }

    public void spend(int accountId, double amount, String type) {
        Transactions transactions = new Transactions();
        ZonedDateTime localDate = ZonedDateTime.now();
        double lastLimit;

        //checking the current limit balance
        if(transactionsRepository.findFirstByAccountIdOrderByTransactionDateDesc(accountId) != null){
            if(transactionsRepository.findFirstByAccountIdOrderByTransactionDateDesc(accountId).getTransactionDate().isAfter(limitRepository.findFirstByAccountIdOrderByLimitDateDesc(accountId).getLimitDate())){
                lastLimit = transactionsRepository.findFirstByAccountIdOrderByTransactionDateDesc(accountId).getLimitBalance();
            }
            else {
                lastLimit = limitRepository.findFirstByAccountIdOrderByLimitDateDesc(accountId).getLimitBalance();
            }
        }
        else {
            lastLimit = limitRepository.findFirstByAccountIdOrderByLimitDateDesc(accountId).getLimitBalance();
        }
        boolean limitExceeded = false;
        lastLimit = lastLimit - amount;
        if(lastLimit < 0) {
            limitExceeded = true;
        }
        transactions.setLimitBalance(lastLimit);
        transactions.setAccountId(accountId);
        transactions.setTransactionDate(localDate);
        transactions.setTransactionType(type);
        transactions.setLimitExceeded(limitExceeded);
        transactions.setTransactionAmount(amount);
        transactionsRepository.save(transactions);
    }
}
