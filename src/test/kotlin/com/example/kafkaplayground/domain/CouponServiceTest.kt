package com.example.kafkaplayground.domain

import com.example.kafkaplayground.repository.CouponRedisRepository
import com.example.kafkaplayground.repository.CouponRepository
import com.example.kafkaplayground.repository.UserCouponRepository
import com.example.kafkaplayground.repository.UserCouponStockHistoryRepository
import com.example.kafkaplayground.service.CouponService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import kotlin.test.Test


@SpringBootTest
@ExperimentalCoroutinesApi
class CouponServiceTest(
    @Autowired private val couponService: CouponService,
    @Autowired private val couponRepository: CouponRepository,
    @Autowired private val userCouponRepository: UserCouponRepository,
    @Autowired private val couponRedisRepository: CouponRedisRepository,
    @Autowired private val userCouponStockHistoryRepository: UserCouponStockHistoryRepository
) {

    @Test
    fun `assign coupon`() {
        val coupon = Coupon(name = "coupon", stock = 1)
        couponRepository.save(coupon)

        couponService.assignCoupon(1, 1)

        val userCoupon = userCouponRepository.findAll().first()
        assertThat(userCoupon.userId).isEqualTo(1)
    }

    @Test
    fun `assign coupon on multi thread`() {
        val threadCount = 100
        val executorService = Executors.newFixedThreadPool(32)
        val latch = CountDownLatch(threadCount)

        val coupon = Coupon(name = "coupon", stock = 10)
        val created = couponRepository.save(coupon)
        couponRedisRepository.setCouponStock(created.id, 10)

        Array(threadCount) { userId ->
            executorService.submit {
                runCatching { couponService.assignCoupon(created.id, userId) }
                    .also { latch.countDown() }
            }
        }

        latch.await()

        val userCoupons = userCouponRepository.findAll()
        val histories = userCouponStockHistoryRepository.findAll()
        assertThat(userCoupons.size).isEqualTo(10)
        assertThat(histories.size).isEqualTo(10)

    }
}