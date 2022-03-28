package com.heydieproject.rabbitmqmessage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDto {

    private Product product;
    private String message;
    private Boolean status;
}
