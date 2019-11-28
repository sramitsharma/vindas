package com.sramit.vindas.web.rest;

import com.sramit.vindas.service.VindasKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vindas-kafka")
public class VindasKafkaResource {

    private final Logger log = LoggerFactory.getLogger(VindasKafkaResource.class);

    private VindasKafkaProducer kafkaProducer;

    public VindasKafkaResource(VindasKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
