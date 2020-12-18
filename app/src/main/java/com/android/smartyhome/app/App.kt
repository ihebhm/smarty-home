package com.android.smartyhome.app


import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.android.smartyhome.BuildConfig
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate()
    }


}

