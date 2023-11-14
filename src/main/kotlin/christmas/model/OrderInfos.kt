package christmas.model

class OrderInfos(inputOrderInfo: List<List<String>>) {
    private val orderInfos: List<OrderInfo>
    val totalMoney: Int
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

    fun getOrderInfo(): List<OrderInfoDto> {
        return orderInfos.map { it.getOrderInfoDto() }
    }

    companion object {
        private const val ORDER_MENU_INDEX = 0
        private const val ORDER_COUNT_INDEX = 1
    }
}