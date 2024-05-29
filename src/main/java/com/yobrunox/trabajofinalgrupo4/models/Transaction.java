package com.yobrunox.trabajofinalgrupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;

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
    private Date date;

    private Double amount;


    @ManyToOne()
    @JoinColumn(name = "User_id")
    private Users user;


    @ManyToOne
    @JoinColumn(name = "Booking_id")
    private Booking booking;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "transaction")
    private Notifications notifications;

    @ManyToOne
    @JoinColumn(name = "TransactionType_id")
    private TransactionType transactionType;

}
