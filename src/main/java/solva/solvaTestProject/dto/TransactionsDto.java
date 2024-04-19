package solva.solvaTestProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class TransactionsDto {
    private int id;
    private int accountId;
    private double limitBalance;
    private ZonedDateTime transactionDate;
    private double transactionAmount;
    private String transactionType;
    private boolean limitExceeded;

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
