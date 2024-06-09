package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date expirationDate;
    @Column(nullable = false)
    private Integer cvv;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id",nullable = false)
    private Bank bank;

    //Usuario
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public DebitCard(String numberCard, Date expirationDate, Integer cvv, String password, Bank bank, Users user) {
        this.numberCard = numberCard;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.password = password;
        this.bank = bank;
        this.user = user;
    }
}
