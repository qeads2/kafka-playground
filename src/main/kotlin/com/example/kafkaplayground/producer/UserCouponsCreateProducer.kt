package com.example.kafkaplayground.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UserCouponsCreateProducer(
    private val kafkaTemplate: KafkaTemplate<String, Int>
) {
    fun create(userId: Int, couponId: Int) {
        kafkaTemplate.send("user-coupons-create", userId)
    }

}