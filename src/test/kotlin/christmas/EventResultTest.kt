package christmas

import christmas.model.BenefitInfos
import christmas.model.EventResult
import christmas.model.OrderInfos
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class EventResultTest {

    @Test
    fun `이벤트 가능 날짜 계산`() {
        val orderInfos = OrderInfos(
            listOf(
                listOf("티본스테이크", "1"),
                listOf("바비큐립", "1"),
                listOf("초코케이크", "2"),
                listOf("제로콜라", "1")
            )
        )

        val benefitInfos = BenefitInfos(3, orderInfos)
        val result = EventResult(orderInfos, benefitInfos).getTotalMoneyAfterDiscount()
        Assertions.assertThat(result).isEqualTo(
            135754
        )
    }
}