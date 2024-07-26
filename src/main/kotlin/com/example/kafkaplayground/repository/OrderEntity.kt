package com.example.kafkaplayground.repository

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "item_id")
    val itemId: Int,
    @Column(name = "user_id")
    val userId: Int
)