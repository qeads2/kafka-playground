package com.example.kafkaplayground.service

import com.example.kafkaplayground.repository.OrderEntity
import com.example.kafkaplayground.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {
    fun createOrder(userId: Int, itemId: Int): OrderEntity {
        return orderRepository.save(OrderEntity(userId = userId, itemId = itemId))
    }
}