package com.nova.app.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${queue.name}")
    private String queueName;

    @Value("${exchange.name}")
    private String exchangeName;

    @Bean
    public ObjectMapper objectMapper() {
        return JsonMapper
            .builder()
            .findAndAddModules()
            .build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder
            .fanoutExchange(exchangeName)
            .durable(true)
            .build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder
            .durable(queueName)
            .build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder
            .bind(queue())
            .to(fanoutExchange());
    }

}
