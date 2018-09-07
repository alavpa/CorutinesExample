package com.alavpa.corutinesexample.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alavpa.corutinesexample.presentation.base.BasePresenter
import com.alavpa.corutinesexample.presentation.base.BaseView

abstract class BaseActivity<S: BaseView, T: BasePresenter<S>> : AppCompatActivity(){

    var presenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = bindPresenter()
        presenter?.attachView(getView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    abstract fun bindPresenter() : T

    abstract fun getView(): S
}
