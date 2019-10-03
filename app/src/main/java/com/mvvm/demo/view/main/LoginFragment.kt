package com.mvvm.demo.view.main

import androidx.lifecycle.ViewModelProviders
import com.mvvm.demo.R
import com.mvvm.demo.view.common.base.BaseSimpleFragment
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseSimpleFragment<LoginViewModel>() {

    private val activityViewModel by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun getContentResource() = R.layout.login_fragment

    override fun buildViewModel(): LoginViewModel {
        return ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
    }

    override fun initViews() {
        tvContent.text = activityViewModel.userName
    }

}
