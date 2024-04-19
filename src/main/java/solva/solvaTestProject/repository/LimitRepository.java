package solva.solvaTestProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import solva.solvaTestProject.entity.Limits;

import java.time.ZonedDateTime;
import java.util.List;


@Repository
public interface LimitRepository extends JpaRepository<Limits,Integer> {

    Limits findFirstByAccountIdOrderByLimitDateDesc(int id);
}

