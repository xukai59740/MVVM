package com.mvvm.demo.view.main

import androidx.lifecycle.ViewModel
import com.mvvm.demo.domain.authentication.usecase.LoginUseCase
import com.mvvm.demo.view.common.base.BaseViewModelFactory
import javax.inject.Inject

class LoginViewModelFactory : BaseViewModelFactory() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    init {
        component.inject(this)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.cast(LoginViewModel(loginUseCase)) as T
    }
}
