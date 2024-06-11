package com.yobrunox.trabajofinalgrupo4.repository;


import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
