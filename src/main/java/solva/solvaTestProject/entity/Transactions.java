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
    int id;

    @Column(name = "account_id")
    int accountId;

    @Column(name = "limit_balance")
    double limitBalance;

    @Column(name = "transaction_date")
    ZonedDateTime transactionDate;

    @Column(name = "transaction_amount")
    double transactionAmount;

    @Column(name = "transaction_type")
    String transactionType;

    @Column(name = "limit_exceeded")
    boolean limitExceeded;
}
