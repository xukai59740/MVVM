package com.mvvm.demo.data.authentication


import com.mvvm.demo.data.preference.Preference
import com.mvvm.demo.domain.authentication.AuthenticationRepository
import com.mvvm.demo.domain.authentication.entity.AccessToken
import com.mvvm.demo.domain.authentication.entity.Account
import io.reactivex.Single
import javax.inject.Inject

class AuthenticationDataRepository @Inject constructor(
    private val api: AuthenticationApi,
    private val accountDao: AccountDao,
    private val preference: Preference
) : AuthenticationRepository {

    override fun login(mobile: String, pwd: String): Single<Account> {
        return api.login().map {
            Account(123, mobile)
        }.onErrorResumeNext {
            preference.putAccessToken(AccessToken("test access token"))
            accountDao.insert(Account(123, mobile))
            Single.just(Account(123, mobile))
        }
    }
}
