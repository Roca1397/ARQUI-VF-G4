package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DebitCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String numberCard;
    @Column(nullable = false)
    private LocalDate expirationDate;
    @Column(nullable = false)
    private Integer cvv;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id",nullable = false)
    Bank bank;

    //Usuario
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public DebitCard(String numberCard, LocalDate expirationDate, Integer cvv, String password, Bank bank, Users user) {
        this.numberCard = numberCard;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.password = password;
        this.bank = bank;
        this.user = user;
    }
}
