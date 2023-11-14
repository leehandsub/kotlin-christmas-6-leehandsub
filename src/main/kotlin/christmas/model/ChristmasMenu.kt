package christmas.model

enum class ChristmasMenu(val menuKind: MenuKind, val menuName: String, val price: Int) {

    MUSHROOM_SOUP(MenuKind.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuKind.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuKind.APPETIZER, "시저샐러드", 8000),

    T_BONE_STEAK(MenuKind.MAINFOOD, "티본스테이크", 55000),
    BBQ_RIB(MenuKind.MAINFOOD, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuKind.MAINFOOD, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuKind.MAINFOOD, "크리스마스파스타", 25000),


    CHOCO_CAKE(MenuKind.DESSERT, "초코케이크", 15000),
    ICE_CREAM(MenuKind.DESSERT, "아이스크림", 5000),

    ZERO_COLA(MenuKind.DRINK, "제로콜라", 3000),
    RED_WINE(MenuKind.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuKind.DRINK, "샴페인", 25000);

    companion object {
        fun getChristmasMenu(inputName: String): ChristmasMenu {
            val christmasMenu = entries.firstOrNull { it.menuName == inputName }
            requireNotNull(christmasMenu)
            return christmasMenu
        }
    }

}