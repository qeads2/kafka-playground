package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int> {
    fun findOneById(id: Int): UserEntity?
}
