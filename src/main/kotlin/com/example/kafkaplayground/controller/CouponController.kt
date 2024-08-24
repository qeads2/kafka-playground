package com.example.kafkaplayground.controller

import com.example.kafkaplayground.application.CouponApplication
import com.example.kafkaplayground.controller.dto.RequestCouponDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CouponController(
    private val couponApplication: CouponApplication
) {
    @PostMapping(value = ["/coupon"])
    fun requestCoupon(
        @RequestBody requestCouponDto: RequestCouponDto
    ) {
        couponApplication.assignCoupon(1, requestCouponDto.userId)
    }
}