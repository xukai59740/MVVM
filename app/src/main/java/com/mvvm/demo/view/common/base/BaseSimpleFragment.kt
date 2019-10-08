package com.mvvm.demo.view.common.base

import android.os.Bundle
import androidx.annotation.CallSuper

abstract class BaseSimpleFragment<T : BaseViewModel> : BaseFragment() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): T

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.init()
        initLiveDataObservers()
    }

    @CallSuper
    protected open fun initLiveDataObservers() = Unit

}
