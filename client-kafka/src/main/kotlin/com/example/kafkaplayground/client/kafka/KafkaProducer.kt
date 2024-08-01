package com.example.kafkaplayground.client.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    fun send(
        topic: String,
        message: String,
    ) {
        kafkaTemplate.send(topic, message)
    }
}
