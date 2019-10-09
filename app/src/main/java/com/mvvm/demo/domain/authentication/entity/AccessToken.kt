package com.mvvm.demo.domain.authentication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AccessToken(val value: String) : Parcelable {

}
