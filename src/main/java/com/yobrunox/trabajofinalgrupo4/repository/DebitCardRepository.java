package com.yobrunox.trabajofinalgrupo4.repository;

import com.yobrunox.trabajofinalgrupo4.models.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
    @Query(value = "SELECT DC FROM DebitCard DC WHERE DC.user.id = :id")
    Optional<DebitCard> getDebitCardByUserId(@Param("id")Integer id);
}
