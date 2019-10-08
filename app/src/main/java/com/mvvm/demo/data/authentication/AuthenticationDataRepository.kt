package com.mvvm.demo.data.authentication


import com.mvvm.demo.data.preference.Preference
import com.mvvm.demo.domain.authentication.AuthenticationRepository
import com.mvvm.demo.domain.authentication.entity.Account
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationDataRepository @Inject constructor(
    private val api: AuthenticationApi,
    private val preference: Preference
) : AuthenticationRepository {

    override fun login(mobile: String, pwd: String): Single<Account> {
        return api.login().map {
            Account(mobile)
        }.onErrorResumeNext {
            Single.just(Account(mobile))
        }
    }
}
