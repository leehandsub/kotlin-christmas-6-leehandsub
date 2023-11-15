package christmas.model

class BenefitInfo(private val benefit: Benefit, private val totalBenefitDiscountPrice: Int) {
    fun getBenefitDto(): BenefitInfoDto {
        return BenefitInfoDto(benefit.benefitDes, totalBenefitDiscountPrice)
    }
}