package com.mvvm.demo.data.authentication

import io.reactivex.Single
import retrofit2.http.GET


interface AuthenticationApi {
    @GET("shipment/masterdata/reason")
    fun login(): Single<Unit>
}
