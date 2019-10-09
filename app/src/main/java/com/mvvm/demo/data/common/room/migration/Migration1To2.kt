package com.mvvm.demo.data.common.room.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migration1To2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
//        database.beginTransaction()
//        try {
//            database.execSQL(
//                "CREATE TABLE IF NOT EXISTS ${ECommerceAddressArea.TABLE_NAME} (" +
//                        "${ECommerceAddressArea.COLUMN_ID} INTEGER NOT NULL, " +
//                        "${ECommerceAddressArea.COLUMN_PROVINCE} TEXT NOT NULL, " +
//                        "${ECommerceAddressArea.COLUMN_REGION} TEXT NOT NULL, " +
//                        "${ECommerceAddressArea.COLUMN_DISTRICT} TEXT NOT NULL, " +
//                        "${ECommerceAddressArea.COLUMN_POSTALCODE} TEXT NOT NULL, " +
//                        "PRIMARY KEY(${ECommerceAddressArea.COLUMN_ID})" +
//                        ")"
//            )
//            database.delete(SupportedRoute.TABLE_NAME, null, null)
//            database.setTransactionSuccessful()
//        } finally {
//            database.endTransaction()
//        }
    }
}
