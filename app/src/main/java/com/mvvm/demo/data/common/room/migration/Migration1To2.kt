package com.mvvm.demo.data.common.room.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mvvm.demo.domain.authentication.entity.Account

class Migration1To2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE ${Account.TABLE_NAME} ADD COLUMN name TEXT DEFAULT \"\" NOT NULL"
        )
    }
}
