package christmas.view

object OutputView {
    private const val ORDER_DAY_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
    private const val ORDER_MENU_MESSAGE = "<주문 메뉴>"
    private const val ORDER_INFO_MESSAGE = "%s %s개"
    fun printOrderDay(orderDay: Int) {
        println(ORDER_DAY_MESSAGE.format(orderDay))
    }

    fun printOrderInfoMessage() {
        println(ORDER_MENU_MESSAGE)
    }

    fun printOrderInfo(menu: String, count: Int) {
        println(ORDER_INFO_MESSAGE.format(menu, count))
    }
}