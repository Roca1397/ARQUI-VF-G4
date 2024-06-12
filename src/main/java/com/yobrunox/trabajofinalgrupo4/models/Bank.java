package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nameBank;
    private String addressBank;
    @Column(nullable = false)
    private String phoneBank;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    City city;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank", cascade = CascadeType.ALL)
    List<DebitCard> debitCards;

    public Bank(String nameBank, String addressBank, String phoneBank, City city) {
        this.nameBank = nameBank;
        this.addressBank = addressBank;
        this.phoneBank = phoneBank;
        this.city = city;
    }
}
