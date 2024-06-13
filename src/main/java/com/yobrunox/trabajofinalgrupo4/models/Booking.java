package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String description;

    private LocalDate creationDate = LocalDate.now();

    private Double financialTargetAmount; // cantidadobjetivofinanciero
    private Double financialPercentage;
    private Double progress;
    //reservation tpye
    @ManyToOne
    @JoinColumn(name = "reservationType_id")
    ReservationType reservationType;
    //user id
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    Users user;
    //Transaction
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "booking",cascade = CascadeType.ALL)
    List<Transaction> transactions;

    public Booking(String description,Double financialTargetAmount, Double financialPercentage, Double progress,ReservationType reservationType,Users user) {
        this.description = description;
        this.financialTargetAmount = financialTargetAmount;
        this.financialPercentage = financialPercentage;
        this.progress = progress;
        this.reservationType = reservationType;
        this.user = user;
    }
}
