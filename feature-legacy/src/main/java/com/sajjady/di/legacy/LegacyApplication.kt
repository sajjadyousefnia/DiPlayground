package com.sajjady.di.legacy

import android.app.Application
import com.sajjady.di.data.AppConfig
import com.sajjady.di.data.ApplicationContext
import com.sajjady.di.data.di.component.AppComponent
import com.sajjady.di.data.di.component.DaggerAppComponent

class LegacyApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(ApplicationContext("legacy"), AppConfig(flavor = "legacy", isDebug = true))
    }

    fun getAppComponent(): AppComponent = appComponent
}
