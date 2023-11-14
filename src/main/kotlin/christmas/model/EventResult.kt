package christmas.model

class EventResult(private val orderInfos: OrderInfos, private val benefitInfos: BenefitInfos) {
    fun getTotalMoneyAfterDiscount(): Int {
        if (orderInfos.orderInfosTotalMoney >= 120000) {
            return orderInfos.orderInfosTotalMoney - benefitInfos.benefitTotalMoney + ChristmasMenu.CHAMPAGNE.price
        }
        return orderInfos.orderInfosTotalMoney - benefitInfos.benefitTotalMoney
    }

    fun getBadge(): Badge {
        return Badge.getBadge(benefitInfos.benefitTotalMoney)
    }

}