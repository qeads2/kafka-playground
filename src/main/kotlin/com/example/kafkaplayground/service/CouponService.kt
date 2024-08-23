package com.example.kafkaplayground.service

import com.example.kafkaplayground.domain.UserCoupon
import com.example.kafkaplayground.domain.UserCouponStockHistory
import com.example.kafkaplayground.domain.enums.StockHistoryType
import com.example.kafkaplayground.repository.CouponRedisRepository
import com.example.kafkaplayground.repository.CouponRepository
import com.example.kafkaplayground.repository.UserCouponRepository
import com.example.kafkaplayground.repository.UserCouponStockHistoryRepository
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val userCouponRepository: UserCouponRepository,
    private val couponRedisRepository: CouponRedisRepository,
    private val userCouponStockHistoryRepository: UserCouponStockHistoryRepository
) {

    fun assignCoupon(couponId: Int, userId: Int) {
        val couponStock = couponRedisRepository.decreaseCouponStock(couponId, 1)

        println("couponStock: $couponStock")
        if (couponStock == null || couponStock < 0) {
            throw RuntimeException("Coupon out of stock")
        }

        val alreadyAssigned = userCouponRepository.existsByUserIdAndCouponId(userId, couponId)
        if (alreadyAssigned) {
            println("alreadyAssigned: $alreadyAssigned")
            throw RuntimeException("Coupon already assigned")
        }

        userCouponStockHistoryRepository.save(UserCouponStockHistory(
            userId = userId,
            couponId = couponId,
            amount = 1,
            type = StockHistoryType.PLUS
        ))
        userCouponRepository.save(UserCoupon(
            userId = userId,
            couponId = couponId
        ))
    }
}