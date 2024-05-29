package com.yobrunox.trabajofinalgrupo4.repository;

import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationTypeRepository extends JpaRepository<ReservationType, Integer> {
}
