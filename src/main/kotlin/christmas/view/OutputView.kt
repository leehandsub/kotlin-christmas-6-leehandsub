package christmas.view

object OutputView {
    private const val ORDER_DAY_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"
    private const val ORDER_MENU_MESSAGE = "\n<주문 메뉴>"
    private const val ORDER_INFO_MESSAGE = "%s %s개"
    private const val TOTAL_ORDER_INFO_MESSAGE = "\n<할인 전 총주문 금액>"
    private const val BENEFIT_MESSAGE = "\n<혜택 내역>"
    private const val BENEFIT_INFO_MESSAGE = "%s: -%s원"
    private const val BENEFIT_TOTAL_PRICE_MESSAGE = "\n<총혜택 금액>"
    private const val PRICE_MESSAGE = "%s원"
    private const val EVENT_MENU_MESSAGE = "\n<증정 메뉴>"
    private const val NOT = "없음"
    private const val TOTAL_MONEY_AFTER_DISCOUNT = "\n<할인 후 예상 결제 금액>"
    private const val EVENT_BADGE_MESSAGE = "\n<12월 이벤트 배지>"

    fun printNot() {
        println(NOT)
    }

    fun printOrderDay(orderDay: Int) {
        println(ORDER_DAY_MESSAGE.format(orderDay))
    }

    fun printOrderInfoMessage() {
        println(ORDER_MENU_MESSAGE)
    }

    fun printOrderInfo(menu: String, count: Int) {
        println(ORDER_INFO_MESSAGE.format(menu, count))
    }

    fun printTotalOrderInfoMoney() {
        println(TOTAL_ORDER_INFO_MESSAGE)
    }

    fun printBenefitMessage() {
        println(BENEFIT_MESSAGE)
    }

    fun printBenefitInfo(benefitDes: String, benefitTotalPrice: Int) {
        println(BENEFIT_INFO_MESSAGE.format(benefitDes, benefitTotalPrice.addCommas()))
    }

    fun printBenefitTotalPriceMessage() {
        println(BENEFIT_TOTAL_PRICE_MESSAGE)
    }

    fun printBenfitPrice(price: Int) {
        println(PRICE_MESSAGE.format(price.addCommas()))
    }

    private fun Int.addCommas(): String {
        return String.format("%,d", this)
    }

    fun printEventMenuMessage() {
        println(EVENT_MENU_MESSAGE)
    }

    fun printEventMenus(eventMenus: List<String>) {
        eventMenus.forEach {
            println(ORDER_INFO_MESSAGE.format(it, 1))
        }
    }

    fun printTotalMoneyAfterDisCount(totalMoneyAfterDiscount: Int) {
        println(TOTAL_MONEY_AFTER_DISCOUNT)
        printBenfitPrice(totalMoneyAfterDiscount)
    }

    fun printEventBadge(badgeName: String) {
        println(EVENT_BADGE_MESSAGE)
        println(badgeName)
    }

}