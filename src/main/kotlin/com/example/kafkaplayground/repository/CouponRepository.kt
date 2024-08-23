package com.example.kafkaplayground.repository

import com.example.kafkaplayground.domain.Coupon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CouponRepository: JpaRepository<Coupon, Int> {
}