package com.example.couponissue.repository

import com.example.couponissue.domain.UserCoupon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCouponRepository: JpaRepository<UserCoupon, Int> {
    fun existsByUserIdAndCouponId(userId: Int, couponId: Int): Boolean
}