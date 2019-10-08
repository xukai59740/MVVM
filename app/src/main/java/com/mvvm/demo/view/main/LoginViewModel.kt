package com.mvvm.demo.view.main

import androidx.lifecycle.MutableLiveData
import com.mvvm.demo.domain.authentication.entity.Account
import com.mvvm.demo.domain.authentication.usecase.LoginUseCase
import com.mvvm.demo.view.common.base.BaseViewModel
import com.mvvm.demo.view.common.entity.Resource
import com.mvvm.demo.view.common.entity.Status

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    val loginLiveData = MutableLiveData<Resource<Account>>()

    override fun init() {
        super.init()
        loginLiveData.value = Resource(Status.LOADING)
        loginUseCase.execute(
            mapOf(LoginUseCase.PARAM_MOBILE to "18561502657", LoginUseCase.PARAM_PWD to "123")
        ).subscribe({
            loginLiveData.value = Resource(Status.SUCCESS, it)
        }) {
            loginLiveData.value = Resource(Status.ERROR, it)
        }.collect()
    }
}
