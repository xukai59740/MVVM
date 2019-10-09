package com.mvvm.demo.data.preference

import android.content.SharedPreferences
import com.mvvm.demo.data.common.dagger.CryptoHelper
import com.mvvm.demo.domain.authentication.entity.AccessToken

class PreferenceImpl(
    private val pref: SharedPreferences,
    private val cryptoHelper: CryptoHelper
) : Preference {

    companion object {
        private const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
    }

    init {
        cryptoHelper.registerKey(KEY_ACCESS_TOKEN)
    }

    @Synchronized
    override fun getAccessToken(): AccessToken? {
        val accessTokenValue =
            cryptoHelper.decrypt(KEY_ACCESS_TOKEN, pref.getString(KEY_ACCESS_TOKEN, null).orEmpty())
        return accessTokenValue.isEmpty()
            .takeUnless { it }?.run {
                AccessToken(
                    accessTokenValue
                )
            }
    }

    override fun putAccessToken(accessToken: AccessToken) {
        pref.edit().apply {
            putString(KEY_ACCESS_TOKEN, cryptoHelper.encrypt(KEY_ACCESS_TOKEN, accessToken.value))
        }.apply()
    }
}
