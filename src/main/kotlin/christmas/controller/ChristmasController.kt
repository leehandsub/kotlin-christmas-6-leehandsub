package christmas.controller

import christmas.model.OrderInfos
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {

    private lateinit var orderInfos: OrderInfos

    fun playEventPlanner() {
        startEventPlanner()
        calculateDiscount()
    }

    private fun calculateDiscount() {

    }

    private fun startEventPlanner() {
        InputView.printGreeting()
        val orderDay = InputView.getInputDay()
        orderInfos = OrderInfos(InputView.getInputOrderMenu())
        arrangeOrder(orderDay)
    }

    private fun arrangeOrder(orderDay: Int) {
        OutputView.printOrderDay(orderDay)
        OutputView.printOrderInfoMessage()
        val orderInfoDtos = orderInfos.getOrderInfo()
        orderInfoDtos.forEach {
            OutputView.printOrderInfo(it.orderMenu, it.orderCount)
        }
        OutputView.printTotalOrderInfoMoney(orderInfos.totalMoney)
    }


}