package com.shrikant.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.shrikant.messaging.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = (Producer) producer;
    }


    @PostMapping(value = "/publish/{topic}/{employeeId}")
    public void sendMessageToKafkaTopic(@PathVariable("topic") String topic, @PathVariable("employeeId") String id, @RequestBody JsonNode jsonNode) {
        this.producer.publishEvents(topic, id, jsonNode);
    }

}
