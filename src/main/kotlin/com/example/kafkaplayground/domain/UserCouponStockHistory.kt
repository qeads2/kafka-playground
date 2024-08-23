package com.example.kafkaplayground.domain

import com.example.kafkaplayground.domain.enums.StockHistoryType
import com.example.kafkaplayground.domain.enums.StockHistoryTypeConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_coupon_stock_history")
class UserCouponStockHistory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "user_id")
    val userId: Int,
    @Column(name = "coupon_id")
    val couponId: Int,
    val amount: Int,
    @Convert(converter = StockHistoryTypeConverter::class)
    val type: StockHistoryType
)