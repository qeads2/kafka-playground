package com.example.kafkaplayground.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<ItemEntity, Int>{
}