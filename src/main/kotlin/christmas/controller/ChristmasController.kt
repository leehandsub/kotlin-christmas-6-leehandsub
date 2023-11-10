package christmas.controller

import christmas.view.InputView

class ChristmasController {
    fun playEventPlanner(){
        startEventPlanner()
    }

    private fun startEventPlanner(){
        InputView.printGreeting()
        val christmasDay = InputView.getChristmasDay()
    }

}