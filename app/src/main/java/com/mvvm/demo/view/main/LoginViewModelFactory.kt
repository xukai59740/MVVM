package com.mvvm.demo.view.main

import androidx.lifecycle.ViewModel
import com.mvvm.demo.view.common.base.BaseViewModelFactory

class LoginViewModelFactory : BaseViewModelFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(LoginViewModel()) as T
    }
}
