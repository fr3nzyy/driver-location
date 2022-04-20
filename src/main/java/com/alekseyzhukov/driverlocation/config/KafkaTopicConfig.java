package com.alekseyzhukov.driverlocation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.coordinates-topic}")
    private String coordinatesTopic;

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(coordinatesTopic).build();
    }
}
