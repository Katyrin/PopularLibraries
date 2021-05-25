package com.katyrin.popularlibraries.presenter

import com.katyrin.popularlibraries.ButtonNumber
import com.katyrin.popularlibraries.MainView
import com.katyrin.popularlibraries.model.CountersModel

class MainPresenter(private val view: MainView, private val model: CountersModel) {

    fun counterClick(buttonNumber: ButtonNumber) {
        buttonNumber.value
            .let(model::next)
            .let { counter ->
                when (buttonNumber) {
                    ButtonNumber.ONE -> view.setButtonTextOne("$counter")
                    ButtonNumber.TWO -> view.setButtonTextTwo("$counter")
                    ButtonNumber.THREE -> view.setButtonTextThree("$counter")
                }
            }
    }
}