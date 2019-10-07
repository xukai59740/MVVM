package com.mvvm.demo.view.common.dagger

import com.mvvm.demo.data.authentication.AuthenticationModule
import dagger.Module

@Module(
    includes = [
        AuthenticationModule::class
    ]
)
class FeatureModule
