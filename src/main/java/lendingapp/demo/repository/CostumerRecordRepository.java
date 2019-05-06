package lendingapp.demo.repository;

import lendingapp.demo.repository.model.CostumerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CostumerRecordRepository extends JpaRepository<CostumerRecord, Long> {

    @Query("select count(costumer) > 0 from CostumerRecord costumer where"
            + " costumer.email = :email")
    boolean isEmailPresent(@Param("email") String email);

    @Query("select costumer from CostumerRecord costumer where"
            + " costumer.email = :email")
    CostumerRecord findByEmail(@Param("email") String email);

}
