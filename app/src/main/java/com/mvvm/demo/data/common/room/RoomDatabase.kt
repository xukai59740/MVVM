package com.mvvm.demo.data.common.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvm.demo.BuildConfig
import com.mvvm.demo.data.authentication.AccountDao
import com.mvvm.demo.domain.authentication.entity.Account

@Database(
    entities = [
        Account::class
    ],
    version = BuildConfig.DATABASE_VERSION
)
@TypeConverters(
    Account.Converter::class
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}
