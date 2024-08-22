package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<ItemEntity, Int>{
}