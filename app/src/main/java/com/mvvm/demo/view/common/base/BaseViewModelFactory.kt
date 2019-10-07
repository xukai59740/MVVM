package com.mvvm.demo.view.common.base

import androidx.lifecycle.ViewModelProvider
import com.mvvm.demo.view.common.dagger.DaggerViewModelFactoryComponent

abstract class BaseViewModelFactory : ViewModelProvider.Factory {
    protected val component by lazy { DaggerViewModelFactoryComponent.builder().build() }
}
