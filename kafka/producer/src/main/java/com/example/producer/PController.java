package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Person> kafkaTemplate2;

    @GetMapping
    public void send(@RequestParam("msg") String msg) {
        kafkaTemplate.send("tt-topic", msg);
    }

    @PostMapping
    public void post(@RequestBody Person person) {
        kafkaTemplate2.send("test1", person);
    }
}
