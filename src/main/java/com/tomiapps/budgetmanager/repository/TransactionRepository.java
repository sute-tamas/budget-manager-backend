package com.tomiapps.budgetmanager.repository;

import com.tomiapps.budgetmanager.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByItemId(Long id);

}
