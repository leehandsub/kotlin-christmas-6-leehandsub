package christmas

import christmas.model.BenefitInfos
import christmas.model.OrderInfos
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BenefitInfosTest {
    @Test
    fun `총주문 금액이 10000보다 적을 때 테스트`() {
        val result = BenefitInfos(
            3,
            OrderInfos(listOf(listOf("양송이수프", "1")))
        ).benefitTotalMoney
        Assertions.assertThat(result).isEqualTo(
            0
        )
    }

    @Test
    fun `총주문 금액이 10000보다 클 때 테스트`() {
        val result = BenefitInfos(
            3,
            OrderInfos(listOf(listOf("양송이수프", "2")))
        ).benefitTotalMoney
        Assertions.assertThat(result).isEqualTo(
            9800
        )
    }
}