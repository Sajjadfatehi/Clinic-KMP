package com.smart.clinic

import android.app.Application
import com.smart.clinic.di.initKoin
import org.koin.android.ext.koin.androidContext

class ClinicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ClinicApplication)
        }
    }
}