package com.example.kafkaplayground.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "coupon")
class Coupon(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    private var stock: Int
) {

    fun getStock(): Int {
        return stock
    }
    fun decreaseStock() {
        stock--
    }
    fun setStock(stock: Int) {
        this.stock = stock
    }
}