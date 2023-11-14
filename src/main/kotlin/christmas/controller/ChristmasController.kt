package christmas.controller

import christmas.model.BenefitInfos
import christmas.model.OrderInfos
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {

    private lateinit var orderInfos: OrderInfos
    private var orderDay: Int = 0
    private lateinit var benefitInfos: BenefitInfos

    fun playEventPlanner() {
        startEventPlanner()
        calculateBenefit()
        eventResult()
    }

    private fun eventResult() {
        OutputView.printBenefitTotalPriceMessage()
        OutputView.printPrice(-benefitInfos.benefitTotalMoney)
    }

    private fun calculateBenefit() {

        benefitInfos = BenefitInfos(orderDay, orderInfos)
        OutputView.printBenefitMessage()
        val benefitInfoDtos = benefitInfos.getBenefitDtos()
        benefitInfoDtos.forEach {
            OutputView.printBenefitInfo(it.benefitDes, it.benefitTotalPrice)
        }
    }

    private fun startEventPlanner() {
        InputView.printGreeting()
        orderDay = InputView.getInputDay()
        orderInfos = OrderInfos(InputView.getInputOrderMenu())
        OutputView.printOrderDay(orderDay)
        OutputView.printOrderInfoMessage()
        arrangeOrder()
    }

    private fun arrangeOrder() {
        val orderInfoDtos = orderInfos.getOrderDtoInfo()
        orderInfoDtos.forEach {
            OutputView.printOrderInfo(it.orderMenu, it.orderCount)
        }
        val totalMoney = orderInfos.orderInfosTotalMoney
        OutputView.printTotalOrderInfoMoney()
        OutputView.printPrice(totalMoney)
        OutputView.printEventMenuMessage()
        if (totalMoney < 120000) {
            OutputView.printNot()
        } else {
            OutputView.printChampagne()
        }
    }

}