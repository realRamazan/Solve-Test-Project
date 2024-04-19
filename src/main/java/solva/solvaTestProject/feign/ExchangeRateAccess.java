package solva.solvaTestProject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import solva.solvaTestProject.dto.ExchangeRateDto;

@FeignClient(name = "exchangeRateAccess", url = "https://api.twelvedata.com")
public interface ExchangeRateAccess {
    @GetMapping("/exchange_rate")
    ResponseEntity<ExchangeRateDto> getExchangeRate(@RequestParam("symbol") String symbol,
                                                    @RequestParam("apikey") String apikey);
}
