package solva.solvaTestProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class TransactionsDto {
    int id;
    int accountId;
    double limitBalance;
    ZonedDateTime transactionDate;
    double transactionAmount;
    String transactionType;
    boolean limitExceeded;

    public TransactionsDto() {
    }

    public TransactionsDto(int id, int accountId, double limitBalance, ZonedDateTime transactionDate, double transactionAmount, String transactionType, boolean limitExceeded) {
        this.id = id;
        this.accountId = accountId;
        this.limitBalance = limitBalance;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.limitExceeded = limitExceeded;
    }
}
