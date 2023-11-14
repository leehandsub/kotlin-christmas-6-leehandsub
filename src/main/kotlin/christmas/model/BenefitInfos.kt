package christmas.model

class BenefitInfos(orderDay: Int, orderInfos: OrderInfos) {
    private val benefitInfos: List<BenefitInfo>

    init {
        benefitInfos = orderInfos.getBenefitInfos(orderDay)
    }

    fun getBenefitDtos(): List<BenefitInfoDto> {
        return benefitInfos.map {
            it.getBenefitDto()
        }
    }

}