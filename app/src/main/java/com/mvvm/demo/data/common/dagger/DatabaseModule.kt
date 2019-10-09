package com.mvvm.demo.data.common.dagger

import androidx.room.Room
import androidx.room.RoomDatabase.JournalMode
import com.mvvm.demo.BuildConfig
import com.mvvm.demo.data.common.room.RoomDatabase
import com.mvvm.demo.data.common.room.migration.Migration1To2
import com.mvvm.demo.view.common.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(): RoomDatabase {
        return Room.databaseBuilder(
            App.instance,
            RoomDatabase::class.java,
            BuildConfig.DATABASE_NAME
        ).setJournalMode(JournalMode.TRUNCATE)
            .fallbackToDestructiveMigrationOnDowngrade()
            .addMigrations(
                Migration1To2()
            )
            .build()
    }
}
