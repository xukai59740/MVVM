package com.mvvm.demo.view.common.dagger

import com.mvvm.demo.view.main.LoginViewModelFactory
import com.mvvm.demo.view.main.MainViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeatureModule::class])
interface ViewModelFactoryComponent {
    fun inject(target: MainViewModelFactory)
    fun inject(target: LoginViewModelFactory)
}
