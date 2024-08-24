package com.example.kafkaplayground.service

import com.example.kafkaplayground.producer.UserCouponsCreateProducer
import com.example.kafkaplayground.repository.CouponRedisRepository
import com.example.kafkaplayground.repository.CouponRepository
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val couponRedisRepository: CouponRedisRepository,
    private val userCouponsCreateProducer: UserCouponsCreateProducer,
    ) {

    fun assignCoupon(couponId: Int, userId: Int) {
        val couponStock = couponRedisRepository.decreaseCouponStock(couponId, 1)

        println("couponStock: $couponStock")
        if (couponStock == null || couponStock < 0) {
            throw RuntimeException("Coupon out of stock")
        }
        userCouponsCreateProducer.create(userId, couponId)
    }
}