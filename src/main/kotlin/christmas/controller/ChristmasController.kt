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
        InputView.printGreeting()
        orderDay = repeatInputIncorrect { InputView.getInputDay() }

        repeatInputIncorrect { startEventPlanner() }
        calculateBenefit()
        eventResult()
    }

    private fun eventResult() {
        OutputView.printBenefitTotalPriceMessage()
        OutputView.printBenfitPrice(-benefitInfos.benefitTotalMoney)
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


        val inputOrderMenu = InputView.getInputOrderMenu()
        orderInfos = OrderInfos(inputOrderMenu)
        inputOrderMenu.addAll(ChristmasMenu.getEventMenu())

        OutputView.printOrderDay(orderDay)
        OutputView.printOrderInfoMessage()
        arrangeOrder(inputOrderMenu)
    }

    private fun arrangeOrder(inputOrderMenu: MutableList<List<String>>) {
        val orderInfoDtos = orderInfos.getOrderDtoInfo()
        orderInfoDtos.forEach {
            OutputView.printOrderInfo(it.orderMenu, it.orderCount)
        }
        val totalMoney = orderInfos.orderInfosTotalMoney
        OutputView.printTotalOrderInfoMoney()
        OutputView.printBenfitPrice(totalMoney)
        OutputView.printEventMenuMessage()
        if (totalMoney < 120000) {
            OutputView.printNot()
        } else {
            orderInfos = OrderInfos(inputOrderMenu)
            OutputView.printEventMenus(ChristmasMenu.getEventMenu().map { it[0] })
        }
    }

}