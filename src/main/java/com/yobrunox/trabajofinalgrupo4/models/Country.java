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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String nameCountry;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "country",cascade = CascadeType.ALL)
    List<City> cities;

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
