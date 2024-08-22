package com.example.kafkaplayground.domain

import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity(
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
