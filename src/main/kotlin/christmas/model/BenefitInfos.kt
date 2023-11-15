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
        benefitInfos = if (orderInfos.orderInfosTotalMoney >= MINIMUM_DISCOUNT_PRICE) {
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

    companion object {
        private const val MINIMUM_DISCOUNT_PRICE = 10000
    }
}