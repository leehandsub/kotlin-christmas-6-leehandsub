package christmas

import christmas.model.Badge
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BadgeTest {
    @Test
    fun `별 뱃지를 받을 경우 테스트`() {
        val result = Badge.getBadge(5500)
        Assertions.assertThat(result).isEqualTo(
            Badge.STAR
        )
    }

    @Test
    fun `트리 뱃지를 받을 경우 테스트`() {
        val result = Badge.getBadge(15500)
        println(result)
        Assertions.assertThat(result).isEqualTo(
            Badge.TREE
        )
    }

    @Test
    fun `산타 뱃지를 받을 경우 테스트`() {
        val result = Badge.getBadge(25500)
        Assertions.assertThat(result).isEqualTo(
            Badge.SANTA
        )
    }

    @Test
    fun `낫팅 뱃지를 받을 경우 테스트`() {
        val result = Badge.getBadge(1000)
        Assertions.assertThat(result).isEqualTo(
            Badge.NOTTING
        )
    }
}