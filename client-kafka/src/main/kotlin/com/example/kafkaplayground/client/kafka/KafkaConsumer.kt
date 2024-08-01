package com.example.kafkaplayground.client.kafka

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    @KafkaListener(topics = ["myTopic"], groupId = "myGroup")
    fun listen(consumerRecord: ConsumerRecord<String, String>) {
        println("Received: ${consumerRecord.value()}")
    }
}
