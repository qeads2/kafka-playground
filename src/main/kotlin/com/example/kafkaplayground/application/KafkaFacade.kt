package com.example.kafkaplayground.application

import com.example.kafkaplayground.service.ItemService
import com.example.kafkaplayground.service.OrderService
import com.example.kafkaplayground.service.UserService
import org.springframework.stereotype.Service

@Service
class KafkaFacade(
    private val userService: UserService,
    private val itemService: ItemService,
    private val orderService: OrderService
) {
    fun order(userId: Int, itemId: Int): Int {
        val created = orderService.createOrder(userId, itemId)
        itemService.decreaseStock(itemId)
        return created.id
    }
}