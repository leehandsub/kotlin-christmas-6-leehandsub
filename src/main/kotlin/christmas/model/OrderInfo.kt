package christmas.model

class OrderInfo(private val orderMenu: String, private val orderCount: Int) {

    fun getOrderInfoDto(): OrderInfoDto {
        return OrderInfoDto(orderMenu, orderCount)
    }
}