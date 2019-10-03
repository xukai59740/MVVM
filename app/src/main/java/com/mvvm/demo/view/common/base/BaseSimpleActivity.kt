package com.mvvm.demo.view.common.base

import android.os.Bundle
import androidx.annotation.CallSuper


abstract class BaseSimpleActivity<T : BaseViewModel> : BaseActivity() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLiveDataObservers()
    }

    @CallSuper
    protected open fun initLiveDataObservers() = Unit
}
