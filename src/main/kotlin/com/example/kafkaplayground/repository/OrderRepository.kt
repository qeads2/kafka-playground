package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Int>{
}