package com.mvvm.demo.domain.authentication.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Account(
    val mobile: String
) : Parcelable {

}
