package com.example.bank_app.repo;
import com.example.bank_app.models.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRecordRepository extends JpaRepository<TransactionRecord,Long>{
    List<TransactionRecord> findByAccountId(Long accountId);

}
