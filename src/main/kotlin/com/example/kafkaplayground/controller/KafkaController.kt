package com.example.kafkaplayground.controller

import com.example.kafkaplayground.application.KafkaFacade
import com.example.kafkaplayground.dto.OrderItemDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class KafkaController(
    private val kafkaFacade: KafkaFacade,
) {
    @PostMapping(value = ["/order"])
    fun order(
        @RequestBody order: OrderItemDto
    ) {
        kafkaFacade.order(1, order.itemId)
    }
}