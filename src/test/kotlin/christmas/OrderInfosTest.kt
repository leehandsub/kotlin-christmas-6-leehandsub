package christmas

import christmas.model.OrderInfos
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrderInfosTest {

    @Test
    fun `정해진 메뉴가 아닐 때 테스트`() {
        assertThrows<IllegalArgumentException> {
            OrderInfos(listOf(listOf("국밥", "1"), listOf("제로콜라", "1")))
        }
    }

    @Test
    fun `음료만 주문 했을 때 테스트`() {
        assertThrows<IllegalArgumentException> {
            OrderInfos(listOf(listOf("제로콜라", "1"), listOf("샴페인", "1")))
        }
    }

    @Test
    fun `메뉴가 20개 넘었을 때 테스트`() {
        assertThrows<IllegalArgumentException> {
            OrderInfos(listOf(listOf("초코케이크", "21")))
        }
    }
}