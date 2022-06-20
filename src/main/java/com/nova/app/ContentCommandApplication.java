package com.nova.app;

import com.nova.app.rabbitmq.ContentJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContentCommandApplication {

    @Autowired
    private ContentJsonProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(ContentCommandApplication.class, args);
    }
}
