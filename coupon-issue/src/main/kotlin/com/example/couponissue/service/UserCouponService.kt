package com.example.couponissue.service

import com.example.couponissue.domain.UserCoupon
import com.example.couponissue.domain.UserCouponStockHistory
import com.example.couponissue.domain.enums.StockHistoryType
import com.example.couponissue.repository.UserCouponRepository
import com.example.couponissue.repository.UserCouponStockHistoryRepository
import org.springframework.stereotype.Service

@Service
class UserCouponService(
    private val userCouponRepository: UserCouponRepository,
    private val userCouponStockHistoryRepository: UserCouponStockHistoryRepository

) {
    fun issueCoupon(userId: Int, couponId: Int) {
        if (userCouponRepository.existsByUserIdAndCouponId(userId, couponId)) {
            throw RuntimeException("User already has the coupon")
        }
        userCouponRepository.save(UserCoupon(userId = userId, couponId = couponId))
        userCouponStockHistoryRepository.save(UserCouponStockHistory(userId = userId, couponId = couponId, amount = 1, type = StockHistoryType.PLUS))
    }
}