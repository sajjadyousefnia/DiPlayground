package com.sajjady.di.app

import android.app.Application
import com.sajjady.di.app.di.SystemTimeProvider
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.core.util.TimeProvider
import com.sajjady.di.data.di.DaggerDataComponent
import com.sajjady.di.data.di.DataComponent
import com.sajjady.di.data.di.DataComponentProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DiApplication : Application(), DataComponentProvider {

    lateinit var dataComponent: DataComponent
        private set

    override fun onCreate() {
        super.onCreate()
        // The component is created lazily to demonstrate integration between Hilt and a manual graph.
    }

    override fun dataComponent(): DataComponent {
        if (!this::dataComponent.isInitialized) {
            dataComponent = DaggerDataComponent.builder()
                .appConfig(defaultAppConfig())
                .timeProvider(defaultTimeProvider())
                .build()
        }
        return dataComponent
    }

    private fun defaultAppConfig(): AppConfig = AppConfig(
        environment = "dev",
        apiBaseUrl = "https://api.diplayground.dev",
        featureFlags = mapOf(
            "composePlayground" to true,
            "legacyStack" to true
        )
    )

    private fun defaultTimeProvider(): TimeProvider = SystemTimeProvider()
}
