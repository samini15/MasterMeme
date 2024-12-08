package com.example.mastermime

import android.app.Application
import com.example.mastermime.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MasterMemeApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MasterMemeApp)
            androidLogger()

            modules(appModule)
        }
    }
}