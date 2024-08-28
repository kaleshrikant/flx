package com.shrikant.messaging.producer;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


         public void publishEvents(String topic, String id, JsonNode jsonNode) {
        if (StringUtils.isEmpty(topic)) {
            log.error("Error Publishing Record with id = [" + id + "] due to {} kafka topic ", topic);
            return;
        }
        log.info(String.format("Publishing Record with id = [" + id + "] due to {} kafka topic ", topic));
        this.kafkaTemplate.send(topic, id, jsonNode);
    }

}
