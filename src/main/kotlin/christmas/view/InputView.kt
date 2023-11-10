package christmas.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
    private const val CHRISTMAS_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    private const val MENU_INPUT_ANNOUNCE_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    private const val DELIMITER_COMMA = ","
    private const val DELIMITER_DASH = "-"

    fun printGreeting() {
        println(GREETING_MESSAGE)
    }

    fun getInputDay(): Int {
        println(CHRISTMAS_DAY_MESSAGE)
        val inputDay = Console.readLine();

        return inputDay.toInt()
    }

    fun getInputOrderMenu(): List<List<String>> {
        println(MENU_INPUT_ANNOUNCE_MESSAGE)
        return Console.readLine().split(DELIMITER_COMMA).map {
            it.split(DELIMITER_DASH)
        }
    }
}