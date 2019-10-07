package com.mvvm.demo.view.main

import androidx.lifecycle.ViewModel
import com.mvvm.demo.view.common.base.BaseViewModelFactory

class MainViewModelFactory(private val userName: String) : BaseViewModelFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(MainViewModel(userName)) as T
    }
}
