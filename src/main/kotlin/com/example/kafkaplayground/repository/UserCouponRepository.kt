package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.UserCoupon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCouponRepository: JpaRepository<UserCoupon, Int> {
    fun existsByUserIdAndCouponId(userId: Int, couponId: Int): Boolean
}