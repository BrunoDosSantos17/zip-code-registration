package com.santosdosbruno.TelaCadastro.service.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
@Component
public class Template {
    private final RabbitTemplate rabbitTemplate;

    public Template(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String routingKey, String message) {
        rabbitTemplate.convertAndSend(routingKey, message);
    }
}
