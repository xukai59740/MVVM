package com.mvvm.demo.data.common.dagger


import com.mvvm.demo.BuildConfig
import com.mvvm.demo.data.authentication.AccessTokenAuthenticator
import com.mvvm.demo.data.preference.Preference
import com.mvvm.demo.data.preference.PreferenceModule
import com.mvvm.demo.view.common.App
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [CommonModule::class, PreferenceModule::class])
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptors: ArrayList<Interceptor>,
        accessTokenAuthenticator: AccessTokenAuthenticator
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        interceptors.forEach { clientBuilder.addInterceptor(it) }
        clientBuilder.authenticator(accessTokenAuthenticator)
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideAccessTokenAuthenticator(
        preference: Preference
    ): AccessTokenAuthenticator {
        return AccessTokenAuthenticator(preference)
    }

    @Singleton
    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        interceptors.add(ChuckInterceptor(App.instance))
        interceptors.add(loggingInterceptor)
        return interceptors
    }
}
