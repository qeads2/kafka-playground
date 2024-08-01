package com.example.kafkaplayground.domain

import java.time.LocalDateTime

class OrderCompleted(
    val userId: Int,
    val itemId: Int,
    val quantity: Int,
    val createdAt: LocalDateTime,
)
