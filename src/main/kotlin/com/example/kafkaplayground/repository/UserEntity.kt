package com.example.kafkaplayground.repository

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String,
    private var grade: Int = 0,
) {
    fun getGrade(): Int = grade

    fun increaseGrade() {
        grade += 1
    }
}
