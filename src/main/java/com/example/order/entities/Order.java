package com.example.order.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "date")
    private Timestamp timestamp;

    @Column(name = "sum")
    private Integer sum;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "products")
    private List<String> products;
}
