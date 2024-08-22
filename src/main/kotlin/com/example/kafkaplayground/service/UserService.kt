package com.example.kafkaplayground.service

import com.example.kafkaplayground.domain.UserEntity
import com.example.kafkaplayground.repository.UserRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun createUser() {
        userRepository.save(
            UserEntity(
                name = "user-${Random.nextInt(1000)}",
            ),
        )
    }
}
