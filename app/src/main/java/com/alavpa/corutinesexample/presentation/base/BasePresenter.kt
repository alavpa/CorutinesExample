package com.alavpa.corutinesexample.presentation.base

open class BasePresenter<T> {
    var view: T? = null

    fun attachView(view: T) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }
}
