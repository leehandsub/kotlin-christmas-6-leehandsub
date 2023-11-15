package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.OrderInfos.Companion.ERROR_ORDER_INFO_MESSAGE

object InputView {
    private const val GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
    private const val CHRISTMAS_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
    private const val MENU_INPUT_ANNOUNCE_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
    private const val DELIMITER_COMMA = ","
    private const val DELIMITER_DASH = "-"
    private const val ERROR_DAY_RANGE_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요."

    fun printGreeting() {
        println(GREETING_MESSAGE)
    }

    fun getInputDay(): Int {
        println(CHRISTMAS_DAY_MESSAGE)
        val inputDay = checkPositiveInteger(Console.readLine(), ERROR_DAY_RANGE_MESSAGE)
        checkNumberRange(inputDay)
        return inputDay
    }

    fun getInputOrderMenu(): MutableList<List<String>> {
        println(MENU_INPUT_ANNOUNCE_MESSAGE)

        val inputOrderMenu = Console.readLine().split(DELIMITER_COMMA).map {
            it.split(DELIMITER_DASH)
        }.toMutableList()

        checkDuplicateMenu(inputOrderMenu.map { it[0] })
        return inputOrderMenu
    }

    private fun checkDuplicateMenu(menuNames: List<String>) {
        require(menuNames.distinct().size == menuNames.size) {
            errorMessageFormat(ERROR_ORDER_INFO_MESSAGE)
        }
    }

    fun checkPositiveInteger(inputWinningNumber: String, errorMessage: String): Int {
        val winningNumber = inputWinningNumber.toIntOrNull() ?: 0
        require(winningNumber > 0) {
            errorMessageFormat(errorMessage)
        }

        return winningNumber
    }

    private fun checkNumberRange(inputDay: Int) {
        check(inputDay <= 31) {
            errorMessageFormat(ERROR_DAY_RANGE_MESSAGE)
        }
    }

    fun errorMessageFormat(errorMessage: String): String {
        return "[ERROR] %s".format(errorMessage)
    }
}