package com.example.kafkaplayground.service

import com.example.kafkaplayground.domain.OrderCompleted
import com.example.kafkaplayground.kafka.KafkaProducer
import com.example.kafkaplayground.repository.UserRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class UserKafkaConsumer(
    private val userRepository: UserRepository,
    private val kafkaProducer: KafkaProducer,
) {
    @KafkaListener(topics = ["orderCompleted"], groupId = "userService")
    fun userOrderCompleted(
        @Payload event: OrderCompleted,
    ) {
        val user = userRepository.findOneById(event.userId)
        if (user == null) {
            println("User with id ${event.userId} not found")
            return
        }

        user.increaseGrade()
        kafkaProducer.send("userGradeIncreased", "User ${user.id} grade increased to ${user.getGrade()}")
    }
}
