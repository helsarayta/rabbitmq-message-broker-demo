package com.heydieproject.rabbitmqmessage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private String id;
    private String name;
    private String description;
    private Integer qty;
    private Double price;
}
