package com.mvvm.demo.data.preference

import android.content.Context
import android.content.SharedPreferences
import com.mvvm.demo.BuildConfig
import com.mvvm.demo.data.common.CryptoHelper
import com.mvvm.demo.data.common.dagger.EncryptionModule
import com.mvvm.demo.view.common.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [EncryptionModule::class])
class PreferenceModule {

    @Singleton
    @Provides
    fun provideSharedPref(): SharedPreferences {
        return App.instance.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providePreference(
        pref: SharedPreferences,
        cryptoHelper: CryptoHelper
    ): Preference {
        return PreferenceImpl(pref, cryptoHelper)
    }
}
