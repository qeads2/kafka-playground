package com.example.couponissue.repository

import com.example.couponissue.domain.UserCouponStockHistory
import org.springframework.data.jpa.repository.JpaRepository

interface UserCouponStockHistoryRepository: JpaRepository<UserCouponStockHistory, Long> {

}