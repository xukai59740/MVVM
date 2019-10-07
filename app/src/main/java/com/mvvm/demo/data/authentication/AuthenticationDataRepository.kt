package com.mvvm.demo.data.authentication


import com.mvvm.demo.data.preference.Preference
import javax.inject.Inject

class AuthenticationDataRepository @Inject constructor(
    private val api: AuthenticationApi,
    private val preference: Preference
) : AuthenticationRepository {

}
