package com.mvvm.demo.domain.common.base

import com.google.gson.Gson
import com.mvvm.demo.data.common.entity.ErrorResponse
import com.mvvm.demo.domain.common.exception.CommonHttpException
import com.mvvm.demo.domain.common.exception.CommonHttpException.*
import retrofit2.HttpException
import javax.inject.Inject

class ErrorHelper @Inject constructor(private val gson: Gson) {

    fun buildThrowable(throwable: Throwable): Throwable {
        return if (throwable is HttpException) {
            val body = throwable.response().errorBody()?.string()
            val errorResponse =
                body?.let(this::buildErrorResponse) ?: ErrorResponse("Null Body")
            when (throwable.code()) {
                HttpStatusCodes.BAD_REQUEST ->
                    BadRequestHttpException(errorResponse)
                HttpStatusCodes.UNAUTHORIZED ->
                    UnauthorizedHttpException(errorResponse)
                HttpStatusCodes.FORBIDDEN ->
                    ForbiddenHttpException(errorResponse)
                HttpStatusCodes.INTERNAL_SERVER_ERROR ->
                    InternalServerErrorHttpException(errorResponse)
                HttpStatusCodes.NOT_FOUND ->
                    NotFoundErrorHttpException(errorResponse)
                else -> CommonHttpException(errorResponse)
            }
        } else throwable
    }

    private fun buildErrorResponse(body: String): ErrorResponse {
        return try {
            gson.fromJson(body, ErrorResponse::class.java)
        } catch (e: Throwable) {
            ErrorResponse("Unknown Error")
        }
    }
}
