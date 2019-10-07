package com.mvvm.demo.data.authentication

import android.accounts.NetworkErrorException
import com.mvvm.demo.data.preference.Preference
import okhttp3.Authenticator
import okhttp3.Route

class AccessTokenAuthenticator(
    private val preference: Preference
) : Authenticator {

    companion object {
        private const val REQUEST_TOKEN_KEY = "Authorization"
    }

    override fun authenticate(route: Route?, response: okhttp3.Response?): okhttp3.Request? {
        // todo : preference
        val accessToken = ""
        val tokenType = ""
        val request = response?.request()?.newBuilder()?.apply {
            addHeader(REQUEST_TOKEN_KEY, "$tokenType $accessToken")
        }?.build() ?: throw NetworkErrorException("Null response")

        return request.newBuilder()?.build()
    }

}
