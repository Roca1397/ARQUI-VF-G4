package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

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

    private Date creationDate;

    private Double financialTargetAmount; // cantidadobjetivofinanciero
    private Double financialPercentage;
    private Double progress;

    //user id
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    Users user;
    //reservation tpye
    @ManyToOne
    @JoinColumn(name = "reservationType_id")
    ReservationType reservationType;
    //Transaction
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "booking",cascade = CascadeType.ALL)
    List<Transaction> transactions;

    public Booking(String description, Date creationDate, Double financialTargetAmount, Double financialPercentage, Double progress, Users user, ReservationType reservationType) {
        this.description = description;
        this.creationDate = creationDate;
        this.financialTargetAmount = financialTargetAmount;
        this.financialPercentage = financialPercentage;
        this.progress = progress;
        this.user = user;
        this.reservationType = reservationType;
    }
}
