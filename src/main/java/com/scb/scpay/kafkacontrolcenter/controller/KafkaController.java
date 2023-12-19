package com.scb.scpay.kafkacontrolcenter.controller;

import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.scpay.kafkacontrolcenter.consumer.KafkaTopicConsumer;
import com.scb.scpay.kafkacontrolcenter.model.KafkaBrokerMetaInfo;
import com.scb.scpay.kafkacontrolcenter.service.KafkaBrokerService;

import java.util.List;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaBrokerService kafkaBrokerService;

    private KafkaTemplate<String, String> template;
    private KafkaTopicConsumer myTopicConsumer;

    public KafkaController(KafkaTemplate<String, String> template, KafkaTopicConsumer myTopicConsumer) {
        this.template = template;
        this.myTopicConsumer = myTopicConsumer;
    }

    @GetMapping("/kafka/brokerinfo")
    public List<KafkaBrokerMetaInfo> getKafkaBrokerMetaData() {
    	System.out.println("Getting Kafka cluster broker info....");
        return kafkaBrokerService.getKafkaBrokerInfo(template);
    }
    
    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("test-topic", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return myTopicConsumer.getMessages();
    }

}
