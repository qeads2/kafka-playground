package com.example.kafkaplayground.application

import com.example.kafkaplayground.domain.OrderCompleted
import com.example.kafkaplayground.kafka.KafkaProducer
import com.example.kafkaplayground.service.ItemService
import com.example.kafkaplayground.service.OrderService
import com.example.kafkaplayground.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class KafkaFacade(
    private val userService: UserService,
    private val itemService: ItemService,
    private val orderService: OrderService,
    private val kafkaProducer: KafkaProducer,
    private val objectMapper: ObjectMapper,
) {
    fun order(
        userId: Int,
        itemId: Int,
    ): Int {
        userService.createUser()
        itemService.createItem("item-$itemId", 10)
        val created = orderService.createOrder(userId, itemId)
        itemService.decreaseStock(itemId)
        val message = OrderCompleted.from(created, 1)
        println("Order completed: $message")
        kafkaProducer.send("orderCompleted", message)
        return created.id
    }

    fun createUser() {
        userService.createUser()
    }
}
