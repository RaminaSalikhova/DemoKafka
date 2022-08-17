package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sentMessage(Message message) {
        kafkaTemplate.send("messages", "key",new Message(message.getMessage()));
        return "Hello World!";
    }




//    private final KafkaTemplate<String, Message> kafkaTemplate;
//
//    @Autowired
//    public ProducerService(KafkaTemplate<String, Message> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void produce(Message message) {
//        System.out.println("Producing the message: " + message);
//        kafkaTemplate.send("messages", message);
//    }

}
