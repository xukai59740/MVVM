package com.mvvm.demo.domain.authentication

import com.mvvm.demo.domain.authentication.entity.Account
import io.reactivex.Single

interface AuthenticationRepository {
    fun login(mobile: String, pwd: String): Single<Account>
}
