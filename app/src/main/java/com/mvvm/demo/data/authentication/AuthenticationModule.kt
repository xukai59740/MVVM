package com.mvvm.demo.data.authentication

import com.mvvm.demo.data.common.dagger.NetworkModule
import com.mvvm.demo.data.preference.Preference
import com.mvvm.demo.data.preference.PreferenceModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, PreferenceModule::class])
class AuthenticationModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        authenticationApi: AuthenticationApi,
        preference: Preference
    ): AuthenticationRepository {
        return AuthenticationDataRepository(
            authenticationApi,
            preference
        )
    }
}
