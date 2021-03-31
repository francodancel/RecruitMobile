package com.sample.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate()")
    }

    private companion object {
        const val TAG: String = "CoreApplication"
    }

}