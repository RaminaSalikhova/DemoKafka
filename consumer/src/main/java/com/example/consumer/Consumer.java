package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = {"messages"}, groupId = "group-1")
    public void consume(Message message){
        System.out.println("Consuming the message: " + message);
    }
}
