package com.yobrunox.trabajofinalgrupo4.repository;


import com.yobrunox.trabajofinalgrupo4.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t " +
            "WHERE t.booking.reservationType.id = :reservationTypeId " +
            "AND t.user.id = :userId " +
            "AND t.date BETWEEN :startDate AND :endDate")
    List<Transaction> findAllByReservationTypeIdAndUserIdAndDateRange(
            @Param("reservationTypeId") Integer reservationTypeId,
            @Param("userId") Integer userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("SELECT t FROM Transaction t " +
            "WHERE t.user.id = :userId " +
            "AND t.date BETWEEN :startDate AND :endDate")
    List<Transaction> findAlltransacciones(
            @Param("userId") Integer userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}

