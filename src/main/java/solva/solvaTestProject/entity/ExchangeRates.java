package solva.solvaTestProject.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("rates")
public class ExchangeRates {

    @Id
    private String id;

    private String symbol;

    private  double rate;

    private  int timestamp;

    public ExchangeRates(String id, double rate, int timestamp) {
        this.id = id;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public ExchangeRates() {
    }
}
