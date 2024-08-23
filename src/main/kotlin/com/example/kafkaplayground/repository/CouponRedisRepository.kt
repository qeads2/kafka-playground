package com.example.kafkaplayground.repository

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class CouponRedisRepository(
    private val redisTemplate: RedisTemplate<String, String>
)  {
    fun setCouponStock(couponId: Int, stock: Int) {
        redisTemplate.opsForValue().set("coupon-$couponId", stock.toString())
    }

    fun increaseCouponStock(couponId: Int, amount: Int): Long? {
        return redisTemplate.opsForValue().increment("coupon-$couponId", amount.toLong())
    }

    fun decreaseCouponStock(couponId: Int, amount: Int): Long? {
        return redisTemplate.opsForValue().decrement("coupon-$couponId", amount.toLong())
    }
}