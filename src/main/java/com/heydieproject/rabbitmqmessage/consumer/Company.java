package com.heydieproject.rabbitmqmessage.consumer;

import com.heydieproject.rabbitmqmessage.config.MessageConfig;
import com.heydieproject.rabbitmqmessage.dto.ResponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Company {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void queueConsumer(ResponseDto responseDto) {
        System.out.println("Consume : " + responseDto);
    }
}
