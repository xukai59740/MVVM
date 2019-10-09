package com.mvvm.demo.data.authentication

import com.mvvm.demo.data.common.dagger.DatabaseModule
import com.mvvm.demo.data.common.dagger.NetworkModule
import com.mvvm.demo.data.common.room.RoomDatabase
import com.mvvm.demo.data.preference.Preference
import com.mvvm.demo.data.preference.PreferenceModule
import com.mvvm.demo.domain.authentication.AuthenticationRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class, PreferenceModule::class])
class AuthenticationModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAccountDao(database: RoomDatabase): AccountDao {
        return database.accountDao()
    }

    @Singleton
    @Provides
    fun provideRepository(
        authenticationApi: AuthenticationApi,
        accountDao: AccountDao,
        preference: Preference
    ): AuthenticationRepository {
        return AuthenticationDataRepository(
            authenticationApi,
            accountDao,
            preference
        )
    }
}
