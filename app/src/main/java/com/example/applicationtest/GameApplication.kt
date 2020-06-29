package com.example.applicationtest

import android.app.Application
import com.example.applicationtest.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GameApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GameApplication)
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}