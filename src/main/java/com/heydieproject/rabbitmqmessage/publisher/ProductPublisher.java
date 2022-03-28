package com.heydieproject.rabbitmqmessage.publisher;

import com.heydieproject.rabbitmqmessage.config.MessageConfig;
import com.heydieproject.rabbitmqmessage.dto.Product;
import com.heydieproject.rabbitmqmessage.dto.ResponseDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{company}")
    public ResponseEntity<ResponseDto> sendProduct(@RequestBody Product product, @PathVariable String company) {
        product.setId(UUID.randomUUID().toString());

        ResponseDto responseDto = new ResponseDto();
        responseDto.setProduct(product);
        responseDto.setMessage("Product send to : " + company);
        responseDto.setStatus(true);
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTINGKEY, responseDto);
        return ResponseEntity.ok(responseDto);
    }
}
