package com.mvvm.demo.view.common

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.mvvm.demo.BuildConfig
import com.mvvm.demo.view.notification.NotificationChannelIds


class App : MultiDexApplication() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initNotificationChannel()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "DEFAULT"
            val channel =
                NotificationChannel(
                    NotificationChannelIds.DEFAULT,
                    name,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}

