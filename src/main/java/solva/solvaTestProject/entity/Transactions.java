package solva.solvaTestProject.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table
@Data
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "limit_balance")
    private double limitBalance;

    @Column(name = "transaction_date")
    private ZonedDateTime transactionDate;

    @Column(name = "transaction_amount")
    private double transactionAmount;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "limit_exceeded")
    private boolean limitExceeded;
}
