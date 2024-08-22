package com.example.kafkaplayground.domain

import jakarta.persistence.*

@Entity
@Table(name = "items")
class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    private var stock: Int,
) : BaseEntity() {
    fun decreaseStock() {
        if (stock == 0) {
            throw RuntimeException("Stock is empty")
        }
        stock -= 1
    }
}
