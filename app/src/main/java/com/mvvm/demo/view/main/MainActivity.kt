package com.mvvm.demo.view.main

import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mvvm.demo.R
import com.mvvm.demo.view.common.base.BaseSimpleActivity
import kotlinx.android.synthetic.main.default_app_bar.*

class MainActivity : BaseSimpleActivity<MainViewModel>() {

    override fun getContentResource() = R.layout.activity_main

    override fun buildViewModel(): MainViewModel {
        return ViewModelProviders.of(this)[MainViewModel::class.java]
    }

    override fun getActionToolbar() = toolbar

    override fun configureActionBar(actionBar: ActionBar) {
        super.configureActionBar(actionBar)
        with(actionBar) {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            title = findNavController(R.id.contentFragment).currentDestination?.label
        }
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
    }

    override fun initViews() {
        super.initViews()
    }

}
