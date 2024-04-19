package solva.solvaTestProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import solva.solvaTestProject.dto.ExchangeRateDto;
import solva.solvaTestProject.entity.ExchangeRates;
import solva.solvaTestProject.feign.ExchangeRateAccess;
import solva.solvaTestProject.repository.ExchangeRatesRepository;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRateAccess exchangeRateAccess;

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Value("${exchange.rates.apikey}")
    private String APIKEY;

    public ExchangeRateDto getRates(String symbol){
        ExchangeRateDto exchangeRatesDto = exchangeRateAccess.getExchangeRate(symbol, APIKEY).getBody();
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.setRate(exchangeRatesDto.getRate());
        exchangeRates.setTimestamp(exchangeRatesDto.getTimestamp());
        exchangeRates.setSymbol(symbol);
        exchangeRatesRepository.save(exchangeRates);
        return exchangeRateAccess.getExchangeRate(symbol, APIKEY).getBody();
    }
}
