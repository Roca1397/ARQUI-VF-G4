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
public class ReservationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "reservationType",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public ReservationType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
