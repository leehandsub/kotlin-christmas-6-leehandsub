package christmas

import christmas.model.Benefit
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BenefitTest {
    @Test
    fun `이벤트 가능 날짜 계산`() {
        val result = Benefit.getBenefits(3)
        Assertions.assertThat(result).isEqualTo(
            listOf(
                Benefit.CHRISTMAS_DAY_DISCOUNTS, Benefit.WEEKDAY_DISCOUNT,
                Benefit.GIFT_EVENT
            )
        )
    }

    @Test
    fun `주말일 때 테스트`() {
        val result = Benefit.getBenefits(8)
        Assertions.assertThat(result).isEqualTo(
            listOf(
                Benefit.CHRISTMAS_DAY_DISCOUNTS, Benefit.WEEKEND_DISCOUNT,
                Benefit.GIFT_EVENT
            )
        )
    }

    @Test
    fun `특별 할인일 때 테스트`() {
        val result = Benefit.getBenefits(25)
        Assertions.assertThat(result).isEqualTo(
            listOf(
                Benefit.CHRISTMAS_DAY_DISCOUNTS, Benefit.WEEKDAY_DISCOUNT, Benefit.SPECIAL_DISCOUNT, Benefit.GIFT_EVENT
            )
        )
    }

    @Test
    fun `디데이 할인 없을 때 테스트`() {
        val result = Benefit.getBenefits(26)
        Assertions.assertThat(result).isEqualTo(
            listOf(
                Benefit.WEEKDAY_DISCOUNT, Benefit.GIFT_EVENT
            )
        )
    }
}