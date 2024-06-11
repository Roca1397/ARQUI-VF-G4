package com.yobrunox.trabajofinalgrupo4.repository;

import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import com.yobrunox.trabajofinalgrupo4.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}
