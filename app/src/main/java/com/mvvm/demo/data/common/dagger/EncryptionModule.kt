package com.mvvm.demo.data.common.dagger

import com.mvvm.demo.view.common.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EncryptionModule {

    @Singleton
    @Provides
    fun provideCryptoHelper(): CryptoHelper {
        return CryptoHelper(App.instance.applicationContext)
    }
}
