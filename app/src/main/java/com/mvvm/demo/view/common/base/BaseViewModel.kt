package com.mvvm.demo.view.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    open fun init() = Unit

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
