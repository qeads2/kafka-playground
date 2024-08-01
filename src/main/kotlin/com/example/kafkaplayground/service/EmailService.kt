package com.example.kafkaplayground.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class EmailService  {
    @KafkaListener(topics = ["userGradeIncreased"], groupId = "emailService")
    fun userGradeIncreased(message: String) {
        println("Email sent: $message")
    }
}
