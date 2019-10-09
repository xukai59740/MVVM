package com.mvvm.demo.data.preference

import com.mvvm.demo.domain.authentication.entity.AccessToken


interface Preference {

    fun getAccessToken(): AccessToken?
    fun putAccessToken(accessToken: AccessToken)
}
