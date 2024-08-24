package com.example.couponissue.consumer

import com.example.couponissue.service.UserCouponService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class UserCouponCreateConsumer(
    private val userCouponService: UserCouponService,
) {
    @KafkaListener(topics = ["user-coupons-create"])
    fun consume(userId: Int) {
        userCouponService.issueCoupon(userId, 1)
    }
}