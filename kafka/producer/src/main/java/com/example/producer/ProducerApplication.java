package com.example.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }


    @Bean
    public NewTopic topic() {
        return new NewTopic("tt-topic", 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("test1").build();
    }
}