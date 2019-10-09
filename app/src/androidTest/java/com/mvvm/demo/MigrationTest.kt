package com.mvvm.demo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.mvvm.demo.data.common.room.migration.Migration1To2
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MigrationTest {

    companion object {
        const val TEST_DB = "com.mvvm.demo.migrationtest"
    }

    @Rule
    @JvmField
    var migrationTestHelper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        com.mvvm.demo.data.common.room.RoomDatabase::class.java.canonicalName,
        FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    fun testMigration1To2() {
        val database = migrationTestHelper.createDatabase(TEST_DB, 1)
        insertAccount(database)
        database.close()
        migrationTestHelper.runMigrationsAndValidate(TEST_DB, 2, true, Migration1To2())
    }

    private fun insertAccount(database: SupportSQLiteDatabase) {
        val contentValues = ContentValues()
        contentValues.put("id", 124)
        contentValues.put("mobile", "15151351251123")
        database.insert("Account", SQLiteDatabase.CONFLICT_REPLACE, contentValues)
    }

}
