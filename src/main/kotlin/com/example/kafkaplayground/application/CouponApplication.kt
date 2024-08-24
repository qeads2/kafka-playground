package com.example.kafkaplayground.application

import com.example.kafkaplayground.service.CouponService
import org.springframework.stereotype.Service

@Service
class CouponApplication(
    private val couponService: CouponService
) {
    fun assignCoupon(couponId: Int, userId: Int) {
        couponService.assignCoupon(couponId, userId)
    }
}