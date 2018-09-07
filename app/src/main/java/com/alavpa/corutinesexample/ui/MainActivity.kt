package com.alavpa.corutinesexample.ui

import android.os.Bundle
import android.view.View
import com.alavpa.corutinesexample.R
import com.alavpa.corutinesexample.presentation.MainPresenter
import com.alavpa.corutinesexample.presentation.MainView
import com.alavpa.corutinesexample.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.loader
import kotlinx.android.synthetic.main.activity_main.resultText

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter?.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.simpleExample()
    }

    override fun setText(text: String) {
        resultText.text = text
    }

    override fun showLoading() {
        resultText.visibility = View.GONE
        loader.show()
    }

    override fun hideLoading() {
        resultText.visibility = View.VISIBLE
        loader.hide()
    }

    override fun getView(): MainView {
        return this
    }

    override fun bindPresenter(): MainPresenter {
        return MainPresenter()
    }
}
