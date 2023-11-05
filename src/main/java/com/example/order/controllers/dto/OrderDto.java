package com.example.order.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private  UUID uuid;

    private Timestamp timestamp;

    private Integer sum;

    private UUID clientId;

    private List<String> products;
}
