package solva.solvaTestProject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table
@Data
public class Limits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id")
    private int accountId;

    @Column(name = "limit_date")
    private ZonedDateTime limitDate;

    @Column(name = "limit_balance")
    private double limitBalance;

    @Column(name = "currency_shortname")
    private String currencyShortname;

}
