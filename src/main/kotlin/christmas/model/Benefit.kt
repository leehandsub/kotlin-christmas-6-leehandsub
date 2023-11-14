package christmas.model

enum class Benefit(val benefitDes: String, val benefitPrice: Int, val possibleDates: List<Int>) {
    CHRISTMAS_DAY_DISCOUNTS("크리스마스 디데이 할인", 100, (1..25).toList()),
    WEEKDAY_DISCOUNT("평일 할인", 2023, (1..31).toList() - listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    WEEKEND_DISCOUNT("주말 할인", 2023, listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    SPECIAL_DISCOUNT("특별 할인", 1000, listOf(3, 10, 17, 24, 25, 31)),
    GIFT_EVENT("증정 이벤트", 25000, (1..31).toList());//이 리스트도 만들게 하면 좋을듯? inferface해서

    companion object {
        fun getBenefits(orderDay: Int): List<Benefit> {
            return entries.filter {
                it.possibleDates.contains(orderDay)
            }
        }
    }
}