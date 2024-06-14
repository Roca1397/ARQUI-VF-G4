package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private LocalDate date= LocalDate.now();
    private Double amount;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    Users user;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    Booking booking;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "transaction")
    Notifications notifications;

    public Transaction(LocalDate date, Double amount, Users user, Booking booking, Notifications notifications) {
        this.date = date;
        this.amount = amount;
        this.user = user;
        this.booking = booking;
        this.notifications = notifications;
    }

    public Transaction(Double amount, Users user, Booking booking) {
        this.amount = amount;
        this.user = user;
        this.booking = booking;
    }

}
