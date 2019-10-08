package com.mvvm.demo.domain.common.exception

import com.mvvm.demo.data.common.entity.ErrorResponse

open class CommonHttpException(private val response: ErrorResponse, message: String? = null) :
    Exception(message) {

    override val message: String
        get() = response.message

    class BadRequestHttpException(response: ErrorResponse) :
        CommonHttpException(response, "Bad Request")

    class UnauthorizedHttpException(response: ErrorResponse) :
        CommonHttpException(response, "Unauthorized")

    class ForbiddenHttpException(response: ErrorResponse) :
        CommonHttpException(response, "Forbidden")

    class InternalServerErrorHttpException(response: ErrorResponse) :
        CommonHttpException(response, "Internal Server Error")

    class NotFoundErrorHttpException(response: ErrorResponse) :
        CommonHttpException(response, "Not Found")
}
