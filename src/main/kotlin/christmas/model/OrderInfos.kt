package christmas.model

class OrderInfos(inputOrderInfo: List<List<String>>) {
    private val orderInfos: List<OrderInfo>
    val orderInfosTotalMoney: Int
        get() {
            return orderInfos.fold(0) { total, orderInfo ->
                total + orderInfo.getOrderInfoTotalMoney()
            }
        }

    init {
        orderInfos = inputOrderInfo.map {
            OrderInfo(
                ChristmasMenu.getChristmasMenu(it[ORDER_MENU_INDEX]), it[ORDER_COUNT_INDEX].toInt()
            )
        }
    }

    fun setEventMenuOrderInfos() {
        orderInfos.forEach {
            it.increaseEventMenuOrderCount()
        }
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
                return 1000 + benefit.benefitPrice * (orderDay - 1)
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
        private const val ORDER_MENU_INDEX = 0
        private const val ORDER_COUNT_INDEX = 1
    }
}