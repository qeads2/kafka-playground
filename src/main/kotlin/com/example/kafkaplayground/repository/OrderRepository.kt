package com.example.kafkaplayground.repository

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<OrderEntity, Int>{
}