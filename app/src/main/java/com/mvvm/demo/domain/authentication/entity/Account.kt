package com.mvvm.demo.domain.authentication.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mvvm.demo.domain.authentication.entity.Account.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class Account(
    @ColumnInfo(name = COLUMN_ID) @PrimaryKey val id: Long,
    @ColumnInfo(name = COLUMN_MOBILE) val mobile: String
) : Parcelable {

    companion object {
        internal const val TABLE_NAME = "Account"
        internal const val COLUMN_ID = "id"
        internal const val COLUMN_MOBILE = "mobile"
    }

    class Converter {
        @TypeConverter
        fun toAccount(json: String?): Account? {
            if (json == null) return null
            return Gson().fromJson(json, Account::class.java)
        }

        @TypeConverter
        fun fromAccount(account: Account?): String? {
            if (account == null) return null
            return Gson().toJson(account)
        }
    }
}
