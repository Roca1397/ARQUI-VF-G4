package com.yobrunox.trabajofinalgrupo4.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nameCity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    Country country;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<Bank> banks;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<Users> users;

    public City(String nameCity, Country country) {
        this.nameCity = nameCity;
        this.country = country;
    }
}
