package solva.solvaTestProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class LimitDto {

    private int id;
    private int accountId;
    private ZonedDateTime limitDate;
    private double limit;
    private String currencyShortname;

    public LimitDto(int id, int accountId, ZonedDateTime limitDate, double limit, String currencyShortname) {
        this.id = id;
        this.accountId = accountId;
        this.limitDate = limitDate;
        this.limit = limit;
        this.currencyShortname = currencyShortname;
    }

    public LimitDto() {
    }
}
