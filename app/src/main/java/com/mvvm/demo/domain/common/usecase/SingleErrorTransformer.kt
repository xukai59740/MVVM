package com.lionparcel.services.consumer.domain.common

import com.mvvm.demo.domain.common.usecase.ErrorHelper
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import javax.inject.Inject

class SingleErrorTransformer<T> @Inject constructor(private val errorHelper: ErrorHelper) :
    SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.onErrorResumeNext {
            Single.error(errorHelper.buildThrowable(it))
        }
    }
}
