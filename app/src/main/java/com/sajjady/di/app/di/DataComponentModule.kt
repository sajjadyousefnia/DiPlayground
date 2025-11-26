package com.sajjady.di.app.di

import android.app.Application
import com.sajjady.di.app.DiApplication
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.core.util.TimeProvider
import com.sajjady.di.data.di.DaggerDataComponent
import com.sajjady.di.data.di.DataComponent
import com.sajjady.di.data.di.FileLogger
import com.sajjady.di.data.di.LogcatLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class SystemTimeProvider : TimeProvider {
    override fun now(): Long = System.currentTimeMillis()
}

@Module
@InstallIn(SingletonComponent::class)
object AppHiltModule {

    @Provides
    @Singleton
    fun provideAppConfig(): AppConfig = AppConfig(
        environment = "dev",
        apiBaseUrl = "https://api.diplayground.dev",
        featureFlags = mapOf(
            "composePlayground" to true,
            "legacyStack" to true
        )
    )

    @Provides
    @Singleton
    fun provideTimeProvider(): TimeProvider = SystemTimeProvider()

    @Provides
    @Singleton
    fun provideDataComponent(
        application: Application,
        appConfig: AppConfig,
        timeProvider: TimeProvider
    ): DataComponent {
        val component = DaggerDataComponent.builder()
            .appConfig(appConfig)
            .timeProvider(timeProvider)
            .build()
        if (application is DiApplication) {
            application.dataComponent = component
        }
        return component
    }

    @Provides
    fun provideAnalyticsService(component: DataComponent): AnalyticsService = component.analyticsService()

    @Provides
    @LogcatLogger
    fun provideLogcatAnalytics(component: DataComponent): AnalyticsService = component.logcatAnalytics()

    @Provides
    @FileLogger
    fun provideFileAnalytics(component: DataComponent): AnalyticsService = component.fileAnalytics()

    @Provides
    fun provideUserSessionManager(component: DataComponent): UserSessionManager = component.userSessionManager()

    @Provides
    fun provideAnalyticsSet(component: DataComponent): Set<@JvmSuppressWildcards AnalyticsService> = component.multiboundAnalytics()

    @Provides
    fun provideAnalyticsMap(component: DataComponent): Map<String, @JvmSuppressWildcards AnalyticsService> = component.analyticsMap()
}
