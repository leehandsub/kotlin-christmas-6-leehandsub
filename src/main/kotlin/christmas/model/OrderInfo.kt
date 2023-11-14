package christmas.model

class OrderInfo(private val orderMenu: ChristmasMenu, private val orderCount: Int) {
    fun getOrderInfoDto(): OrderInfoDto {
        return OrderInfoDto(orderMenu.menuName, orderCount)
    }

    fun getOrderInfoTotalMoney(): Int {
        return orderMenu.price * orderCount
    }

    fun getMenuOrderCount(menuKind: MenuKind): Int {
        if (menuKind == orderMenu.menuKind) {
            return orderCount
        }
        return 0
    }

}