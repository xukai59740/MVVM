package com.mvvm.demo.view.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mvvm.demo.R
import com.mvvm.demo.domain.authentication.entity.Account
import com.mvvm.demo.view.common.base.BaseSimpleFragment
import com.mvvm.demo.view.common.entity.Resource
import com.mvvm.demo.view.common.entity.Status
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseSimpleFragment<LoginViewModel>() {

    private val activityViewModel by lazy {
        ViewModelProviders.of(requireActivity())[MainViewModel::class.java]
    }

    override fun getContentResource() = R.layout.login_fragment

    override fun buildViewModel(): LoginViewModel {
        val factory = LoginViewModelFactory()
        return ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.loginLiveData.observe(viewLifecycleOwner, Observer(this::handleLogin))
    }

    private fun handleLogin(resource: Resource<Account>) {
        when(resource.status){
            Status.LOADING->{

            }
            Status.SUCCESS->{
                tvResult.text = resource.item?.mobile
            }
            Status.ERROR->{

            }
        }
    }

    override fun initViews() {
        tvContent.text = activityViewModel.userName
    }

}
