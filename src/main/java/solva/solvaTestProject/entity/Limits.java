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
    int id;

    @Column(name = "account_id")
    int accountId;

    @Column(name = "limit_date")
    ZonedDateTime limitDate;

    @Column(name = "limit_balance")
    double limitBalance;

    @Column(name = "currency_shortname")
    String currencyShortname;

}
