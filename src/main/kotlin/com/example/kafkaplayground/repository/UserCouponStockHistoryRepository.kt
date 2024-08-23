package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.UserCouponStockHistory
import org.springframework.data.jpa.repository.JpaRepository

interface UserCouponStockHistoryRepository: JpaRepository<UserCouponStockHistory, Long> {

}