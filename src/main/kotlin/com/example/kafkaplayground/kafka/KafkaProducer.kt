package com.example.kafkaplayground.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper = jacksonObjectMapper(),
) {
    fun send(
        topic: String,
        message: Any,
    ) {
        kafkaTemplate.send(topic, objectMapper.writeValueAsString(message))
    }
}
