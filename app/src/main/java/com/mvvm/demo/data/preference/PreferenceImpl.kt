package com.mvvm.demo.data.preference

import android.content.SharedPreferences
import com.mvvm.demo.data.common.CryptoHelper
import java.util.*

class PreferenceImpl(
    private val pref: SharedPreferences,
    private val cryptoHelper: CryptoHelper
) : Preference {

    companion object {

        private const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
        private const val KEY_ACCESS_TOKEN_EXPIRED_AT = "KEY_ACCESS_TOKEN_EXPIRED_AT"
        private const val KEY_ACCESS_TOKEN_TYPE = "KEY_ACCESS_TOKEN_TYPE"

        private const val KEY_ACCOUNT_ID = "KEY_ACCOUNT_ID"
        private const val KEY_ACCOUNT_PHONE_NUMBER = "KEY_ACCOUNT_PHONE_NUMBER"
        private const val KEY_ACCOUNT_ROLE = "KEY_ACCOUNT_ROLE"
        private const val KEY_ACCOUNT_FULLNAME = "KEY_ACCOUNT_FULLNAME"
        private const val KEY_ACCOUNT_PICTURE = "KEY_ACCOUNT_PICTURE"

        private const val KEY_FCM_TOKEN = "KEY_FCM_TOKEN"
    }

    init {
        cryptoHelper.registerKey(KEY_ACCESS_TOKEN)
        cryptoHelper.registerKey(KEY_ACCESS_TOKEN_EXPIRED_AT)
        cryptoHelper.registerKey(KEY_ACCESS_TOKEN_TYPE)

        cryptoHelper.registerKey(KEY_ACCOUNT_ID)
        cryptoHelper.registerKey(KEY_ACCOUNT_PHONE_NUMBER)
        cryptoHelper.registerKey(KEY_ACCOUNT_ROLE)
        cryptoHelper.registerKey(KEY_ACCOUNT_FULLNAME)
        cryptoHelper.registerKey(KEY_ACCOUNT_PICTURE)

        cryptoHelper.registerKey(KEY_FCM_TOKEN)
    }


}
