package christmas.model


class BenefitInfos(orderDay: Int, orderInfos: OrderInfos) {
    private val benefitInfos: List<BenefitInfo>
    val benefitTotalMoney: Int
        get() {
            return benefitInfos.fold(0) { total, benefitInfo ->
                total + benefitInfo.getBenefitDto().benefitTotalPrice
            }
        }

    init {
        benefitInfos = if (orderInfos.orderInfosTotalMoney >= 10000) {
            orderInfos.getBenefitInfos(orderDay)
        } else {
            listOf()
        }
    }

    fun getBenefitDtos(): List<BenefitInfoDto> {
        return benefitInfos.map {
            it.getBenefitDto()
        }
    }


}