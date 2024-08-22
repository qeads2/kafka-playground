package com.example.kafkaplayground.domain

import java.time.LocalDateTime

class OrderCompleted(
    val userId: Int,
    val itemId: Int,
    val quantity: Int,
    val createdAt: LocalDateTime,
) {
    companion object {
        fun from(
            orderEntity: OrderEntity,
            quantity: Int,
        ): OrderCompleted =
            OrderCompleted(
                userId = orderEntity.userId,
                itemId = orderEntity.itemId,
                quantity = quantity,
                createdAt = orderEntity.createdAt,
            )
    }
}
