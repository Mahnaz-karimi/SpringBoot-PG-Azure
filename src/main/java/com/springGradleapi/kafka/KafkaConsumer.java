package com.springGradleapi.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="selftuts", groupId="my_group_id")
    public void getMessage(String message){

        System.out.println(message);

    }
}
