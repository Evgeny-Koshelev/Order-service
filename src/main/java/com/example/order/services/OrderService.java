package com.example.order.services;

import com.example.order.controllers.dto.OrderDto;
import com.example.order.controllers.mapper.OrderDtoMapper;
import com.example.order.entities.Order;
import com.example.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {


    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderDto add(OrderDto orderDto) {
        Order order;
        order = OrderDtoMapper.INSTANCE.toEntity(orderDto);
        order.setId(UUID.randomUUID());
        return OrderDtoMapper.INSTANCE.toDto(repository.save(order));
    }
    public OrderDto getById(UUID id) {
        return OrderDtoMapper.INSTANCE.toDto(repository.getById(id));
    }

}
