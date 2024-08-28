package com.shrikant.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    /*  This method will be triggered whenever a message is received on the configured topic. */

    @KafkaListener(topics = {"RCD-BLD_TOPIC"}, groupId = "RCD-BLD_CG")
    public void listen(String message, Acknowledgment acknowledgment) {
        long start = System.currentTimeMillis();
        log.info(String.format("Respsonse Recived in {} ", System.currentTimeMillis() - start));
        acknowledgment.acknowledge();
    }

}
