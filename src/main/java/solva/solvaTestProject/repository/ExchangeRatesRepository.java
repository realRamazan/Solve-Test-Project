package solva.solvaTestProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import solva.solvaTestProject.entity.ExchangeRates;

@Repository
public interface ExchangeRatesRepository extends MongoRepository<ExchangeRates, String> {

}
