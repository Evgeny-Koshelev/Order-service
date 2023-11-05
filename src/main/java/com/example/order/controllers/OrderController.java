package com.example.order.controllers;
import com.example.order.controllers.dto.OrderDto;
import com.example.order.entities.Order;
import com.example.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Value( "${deliveryService}" )
    String deliveryService;

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service){
        this.service = service;
    }

    @PostMapping(path = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> createOrder( @RequestBody OrderDto orderDto){
        OrderDto getOrderDto = service.add(orderDto);
        orderDto.setUuid(UUID.randomUUID());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDto> requestEntity = new HttpEntity<>(getOrderDto, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(deliveryService, requestEntity, String.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(Objects.requireNonNullElseGet(getOrderDto, OrderDto::new));

    }

    @GetMapping(path = "/getById",  consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getById(@RequestParam("id") UUID id){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.getById(id));


    }
}
