package christmas.model

import christmas.model.ChristmasMenu.Companion.EVENT_AMOUNT
import christmas.view.InputView.checkPositiveInteger
import christmas.view.InputView.errorMessageFormat

class OrderInfos(inputOrderInfo: List<List<String>>) {
    private val orderInfos: List<OrderInfo>
    private var eventPrice = 0
    val orderInfosTotalMoney: Int
        get() {
            return orderInfos.fold(0) { total, orderInfo ->
                total + orderInfo.getOrderInfoTotalMoney()
            }
        }

    init {
        var orderInfosCount = 0
        orderInfos = inputOrderInfo.map {
            val orderCount = checkPositiveInteger(it[ORDER_COUNT_INDEX], ERROR_ORDER_INFO_MESSAGE)
            orderInfosCount += orderCount
            OrderInfo(
                ChristmasMenu.getChristmasMenu(it[ORDER_MENU_INDEX]),
                orderCount
            )
        }
        require(isOnlyDrink()) {
            errorMessageFormat(ERROR_ORDER_INFO_MESSAGE)
        }
        checkOrderCount(orderInfosCount)
    }

    fun calEventMenu() {
        ChristmasMenu.entries.filter { it.isEventMenu }.map {
            eventPrice += it.price * EVENT_AMOUNT.toInt()
        }
    }

    fun getOrderInfosTotalMoneyAndEventPrice(): Int {
        return orderInfosTotalMoney + eventPrice
    }

    private fun checkOrderCount(orderInfosCount: Int) {
        require(orderInfosCount <= MAX_ORDER_MENU) {
            errorMessageFormat(ERROR_ORDER_INFO_MESSAGE)
        }
    }

    private fun isOnlyDrink(): Boolean {
        return orderInfos.any { !it.isDrink() }
    }

    fun getOrderDtoInfo(): List<OrderInfoDto> {
        return orderInfos.filter { !it.isZeroCount() }.map { it.getOrderInfoDto() }
    }

    fun getBenefitInfos(orderDay: Int): List<BenefitInfo> {
        val benefits = Benefit.getBenefits(orderDay)
        return benefits.map {
            BenefitInfo(it, getBenefitInfo(it, orderDay))
        }
    }

    private fun getBenefitInfo(benefit: Benefit, orderDay: Int): Int {
        when (benefit) {
            Benefit.CHRISTMAS_DAY_DISCOUNTS -> {
                return MIN_CHRISTMAS_DAY_EVENT_PRICE + benefit.benefitPrice * (orderDay - 1)
            }

            Benefit.GIFT_EVENT -> {
                return benefit.benefitPrice
            }

            Benefit.SPECIAL_DISCOUNT -> {
                return benefit.benefitPrice
            }

            Benefit.WEEKDAY_DISCOUNT -> {
                return benefit.benefitPrice * orderInfos.fold(0) { total, orderInfo ->
                    total + orderInfo.getMenuOrderCount(MenuKind.DESSERT)
                }
            }

            Benefit.WEEKEND_DISCOUNT -> {
                return benefit.benefitPrice * orderInfos.fold(0) { total, orderInfo ->
                    total + orderInfo.getMenuOrderCount(MenuKind.MAINFOOD)
                }
            }
        }
    }

    companion object {
        private const val MAX_ORDER_MENU = 20
        private const val MIN_CHRISTMAS_DAY_EVENT_PRICE = 1000

        const val ORDER_MENU_INDEX = 0
        const val ORDER_COUNT_INDEX = 1
        const val ERROR_ORDER_INFO_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요."
    }
}