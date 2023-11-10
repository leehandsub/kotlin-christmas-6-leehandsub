package christmas.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
    private const val CHRISTMAS_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"

    fun printGreeting() {
        println(GREETING_MESSAGE)
    }

    fun getChristmasDay(): Int {
        println(CHRISTMAS_DAY_MESSAGE)
        val christmasDay = Console.readLine();

        return christmasDay.toInt()
    }

}