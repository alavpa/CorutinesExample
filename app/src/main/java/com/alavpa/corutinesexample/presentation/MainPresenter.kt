package com.alavpa.corutinesexample.presentation

import com.alavpa.corutinesexample.domain.GetNumber
import com.alavpa.corutinesexample.domain.GetNumberParams
import com.alavpa.corutinesexample.presentation.base.BasePresenter

class MainPresenter : BasePresenter<MainView>() {
    private val getNumber = GetNumber()
    private val getNumber12 = GetNumberParams()

    fun simpleExample() {
        view?.showLoading()

        getNumber.execute(
            onError = {
                view?.hideLoading()
                view?.setText("Error!")
            },
            onSuccess = {
                view?.hideLoading()
                view?.setText(it)
            }
        )

        getNumber12.execute(GetNumberParams.Params(12),
            onError = {
                view?.hideLoading()
                view?.setText("Error!")
            },
            onSuccess = {
                view?.hideLoading()
                view?.setText("getNumber12 $it")
            })
    }
}
