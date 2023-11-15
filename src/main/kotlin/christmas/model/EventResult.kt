package christmas.model

class EventResult(private val orderInfos: OrderInfos, private val benefitInfos: BenefitInfos) {
    fun getTotalMoneyAfterDiscount(): Int {
        return orderInfos.getOrderInfosTotalMoneyAndEventPrice() - benefitInfos.benefitTotalMoney
    }

    fun getBadge(): Badge {
        return Badge.getBadge(benefitInfos.benefitTotalMoney)
    }

}