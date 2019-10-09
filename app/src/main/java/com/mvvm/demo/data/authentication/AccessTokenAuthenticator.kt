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
        val request = response?.request()?.newBuilder()?.apply {
            //add token
            getAccessToken()?.let {
                val tokenType = "bear"
                addHeader(REQUEST_TOKEN_KEY, "$tokenType $it")
            }
        }?.build() ?: throw NetworkErrorException("Null response")
        return request.newBuilder()?.build()
    }

    private fun getAccessToken(): String? {
        return preference.getAccessToken()?.value
    }

}
