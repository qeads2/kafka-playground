package com.example.kafkaplayground.repository

import jakarta.persistence.*

@Entity
@Table(name = "items")
class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    private var stock: Int
) {
    fun decreaseStock() {
        if (stock == 0) {
            throw RuntimeException("Stock is empty")
        }
        stock -= 1
    }
}