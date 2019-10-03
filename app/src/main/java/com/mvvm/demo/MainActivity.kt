package com.mvvm.demo

import androidx.appcompat.app.ActionBar
import com.mvvm.demo.view.common.base.BaseActivity
import kotlinx.android.synthetic.main.default_app_bar.*

class MainActivity : BaseActivity() {

    override fun getContentResource() = R.layout.activity_main

    override fun initViews() {
        super.initViews()
    }

    override fun getActionToolbar() = toolbar

    override fun configureActionBar(actionBar: ActionBar) {
        super.configureActionBar(actionBar)
        with(actionBar) {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = "Main Screen"
        }
    }

}
