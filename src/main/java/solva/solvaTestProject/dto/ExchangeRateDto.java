package solva.solvaTestProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateDto {
    private String symbol;
    private double rate;
    private int timestamp;

    public ExchangeRateDto(String symbol, double rate, int timestamp) {
        this.symbol = symbol;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    public ExchangeRateDto() {
    }
}
