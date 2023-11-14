package christmas.model

enum class Badge(val badgeName: String, val badgePrice: Int) {
    NOTTING("없음", 0),
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    companion object {
        fun getBadge(price: Int): Badge {
            return when {
                NOTTING.badgePrice >= price -> NOTTING
                STAR.badgePrice >= price -> STAR
                TREE.badgePrice >= price -> TREE
                else -> SANTA
            }
        }
    }
}