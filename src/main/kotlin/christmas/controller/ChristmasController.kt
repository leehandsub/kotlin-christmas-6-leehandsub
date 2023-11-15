package christmas.controller

import christmas.controller.ErrorHandler.repeatInputIncorrect
import christmas.model.BenefitInfos
import christmas.model.ChristmasMenu
import christmas.model.EventResult
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
        OutputView.printBenefitPrice(-benefitInfos.benefitTotalMoney)
        val eventResult = EventResult(orderInfos, benefitInfos)
        OutputView.printTotalMoneyAfterDisCount(eventResult.getTotalMoneyAfterDiscount())
        OutputView.printEventBadge(eventResult.getBadge().badgeName)
    }

    private fun calculateBenefit() {
        benefitInfos = BenefitInfos(orderDay, orderInfos)
        OutputView.printBenefitMessage()
        val benefitInfoDtos = benefitInfos.getBenefitDtos()

        if (benefitInfoDtos.isEmpty()) {
            OutputView.printNot()
        } else {
            benefitInfoDtos.forEach {
                OutputView.printBenefitInfo(it.benefitDes, it.benefitTotalPrice)
            }
        }
    }

    private fun startEventPlanner() {
        InputView.printGreeting()
        orderDay = repeatInputIncorrect { InputView.getInputDay() }
        repeatInputIncorrect { getInputOrderInfo() }
    }

    private fun getInputOrderInfo() {
        val inputOrderMenu = InputView.getInputOrderMenu()
        orderInfos = OrderInfos(inputOrderMenu)
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
        OutputView.printBenefitPrice(totalMoney)
        OutputView.printEventMenuMessage()
        if (totalMoney < MINIMUM_EVENT_PRICE) {
            OutputView.printNot()
        } else {
            OutputView.printEventMenus(ChristmasMenu.getEventMenu())
        }
    }

    companion object {
        const val MINIMUM_EVENT_PRICE = 120000
    }

}