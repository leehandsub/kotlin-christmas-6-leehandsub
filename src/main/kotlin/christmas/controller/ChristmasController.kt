package christmas.controller

import christmas.model.OrderInfo
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    fun playEventPlanner() {
        startEventPlanner()
    }

    private fun startEventPlanner() {
        InputView.printGreeting()
        val orderDay = InputView.getInputDay()
        val inputOrderInfos = InputView.getInputOrderMenu().map {
            OrderInfo(it[ORDER_MENU_INDEX], it[ORDER_COUNT_INDEX].toInt())
        }
        arrangeOrder(orderDay, inputOrderInfos)
    }

    private fun arrangeOrder(orderDay: Int, inputOrderInfos: List<OrderInfo>) {
        OutputView.printOrderDay(orderDay)
        OutputView.printOrderInfoMessage()
        val orderInfoDtos = inputOrderInfos.map {
            it.getOrderInfoDto()
        }
        orderInfoDtos.forEach {
            OutputView.printOrderInfo(it.orderMenu, it.orderCount)
        }
    }


    companion object {
        private const val ORDER_MENU_INDEX = 0
        private const val ORDER_COUNT_INDEX = 1
    }
}