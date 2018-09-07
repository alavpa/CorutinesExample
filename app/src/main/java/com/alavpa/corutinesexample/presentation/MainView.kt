package com.alavpa.corutinesexample.presentation

import com.alavpa.corutinesexample.presentation.base.BaseView

interface MainView : BaseView{
    fun showLoading()
    fun hideLoading()
    fun setText(text: String)
}
