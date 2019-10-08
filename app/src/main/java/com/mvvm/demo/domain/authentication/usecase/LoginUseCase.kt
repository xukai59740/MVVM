package com.mvvm.demo.domain.authentication.usecase

import com.lionparcel.services.consumer.domain.common.SingleErrorTransformer
import com.lionparcel.services.consumer.domain.common.base.BaseSingleUseCase
import com.mvvm.demo.domain.authentication.AuthenticationRepository
import com.mvvm.demo.domain.authentication.entity.Account
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    errorTransformer: SingleErrorTransformer<Account>
) : BaseSingleUseCase<Account>(errorTransformer) {

    companion object {
        const val PARAM_MOBILE = "PARAM_MOBILE"
        const val PARAM_PWD = "PARAM_PWD"
    }

    override fun buildSingle(data: Map<String, Any?>): Single<Account> {
        val mobile = data[PARAM_MOBILE] as String
        val pwd = data[PARAM_PWD] as String
        return authenticationRepository.login(mobile, pwd)
    }
}
