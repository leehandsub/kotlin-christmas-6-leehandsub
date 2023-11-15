package christmas.model

import christmas.model.OrderInfos.Companion.ERROR_ORDER_INFO_MESSAGE
import christmas.view.InputView.errorMessageFormat

enum class ChristmasMenu(val menuKind: MenuKind, val menuName: String, val price: Int, val isEventMenu: Boolean) {

    MUSHROOM_SOUP(MenuKind.APPETIZER, "양송이수프", 6000, false),
    TAPAS(MenuKind.APPETIZER, "타파스", 5500, false),
    CAESAR_SALAD(MenuKind.APPETIZER, "시저샐러드", 8000, false),

    T_BONE_STEAK(MenuKind.MAINFOOD, "티본스테이크", 55000, false),
    BBQ_RIB(MenuKind.MAINFOOD, "바비큐립", 54000, false),
    SEAFOOD_PASTA(MenuKind.MAINFOOD, "해산물파스타", 35000, false),
    CHRISTMAS_PASTA(MenuKind.MAINFOOD, "크리스마스파스타", 25000, false),


    CHOCO_CAKE(MenuKind.DESSERT, "초코케이크", 15000, false),
    ICE_CREAM(MenuKind.DESSERT, "아이스크림", 5000, false),

    ZERO_COLA(MenuKind.DRINK, "제로콜라", 3000, false),
    RED_WINE(MenuKind.DRINK, "레드와인", 60000, false),
    CHAMPAGNE(MenuKind.DRINK, "샴페인", 25000, true);

    companion object {
        fun getChristmasMenu(inputName: String): ChristmasMenu {
            val christmasMenu = entries.firstOrNull { it.menuName == inputName }
            requireNotNull(christmasMenu) {
                errorMessageFormat(ERROR_ORDER_INFO_MESSAGE)
            }
            return christmasMenu
        }

        fun getEventMenu(): List<List<String>> {
            return entries.filter { it.isEventMenu }.map { listOf(it.menuName, "1") }
        }

    }

}