package solva.solvaTestProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import solva.solvaTestProject.entity.Transactions;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    @Query("select t from Transactions t where t.accountId = :id and t.limitExceeded = true and t.transactionDate between :beforeMonthDate and :localDate ")
    List<Transactions> findByIdAndLimitExceeded(int id, ZonedDateTime localDate, ZonedDateTime beforeMonthDate);

    @Query("select sum(t.transactionAmount) from Transactions t where t.accountId = :id and t.transactionDate between :beforeMonthDate and :currentDate")
    Double findByIdAndTransactionAmount(int id, ZonedDateTime currentDate, ZonedDateTime beforeMonthDate);

    Transactions findFirstByAccountIdOrderByTransactionDateDesc(int id);
}
