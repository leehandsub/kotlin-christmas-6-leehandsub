package christmas.model

class OrderInfo(private val orderMenu: ChristmasMenu, private var orderCount: Int) {
    fun getOrderInfoDto(): OrderInfoDto {
        return OrderInfoDto(orderMenu.menuName, orderCount)
    }

    fun isZeroCount(): Boolean {
        return orderCount == 0
    }

    fun isDrink(): Boolean {
        return orderMenu.menuKind == MenuKind.DRINK
    }

    fun increaseEventMenuOrderCount() {
        if (ChristmasMenu.getEventMenu().map { it[0] }.contains(orderMenu.menuName)) {
            orderCount++
        }
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