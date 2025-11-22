package com.sajjady.di.data.di

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.core.util.TimeProvider
import com.sajjady.di.data.analytics.LoggerAnalyticsService
import com.sajjady.di.data.assisted.NoteFormatter
import com.sajjady.di.data.config.FakeRemoteConfig
import com.sajjady.di.data.repo.InMemoryNotesRepository
import com.sajjady.di.data.session.UserSessionManagerImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.assisted.AssistedModule
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import javax.inject.Singleton

@Module(includes = [AssistedFactories::class])
@DisableInstallInCheck
object DataBindingsModule {
    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository = InMemoryNotesRepository()

    @Provides
    @Singleton
    fun provideRemoteConfig(appConfig: AppConfig): RemoteConfig = FakeRemoteConfig(appConfig)

    @Provides
    @Singleton
    fun provideUserSessionManager(): UserSessionManager = UserSessionManagerImpl()

    @Provides
    @Singleton
    @LogcatLogger
    fun provideLogcatAnalytics(): AnalyticsService = LoggerAnalyticsService("logcat")

    @Provides
    @Singleton
    @FileLogger
    fun provideFileAnalytics(): AnalyticsService = LoggerAnalyticsService("file")

    @Provides
    @Singleton
    fun provideAnalyticsService(@LogcatLogger analyticsService: AnalyticsService): AnalyticsService = analyticsService

    @Provides
    @Singleton
    @IntoSet
    fun provideSetItem(@LogcatLogger analyticsService: AnalyticsService): AnalyticsService = analyticsService

    @Provides
    @Singleton
    @IntoSet
    fun provideSecondSet(@FileLogger analyticsService: AnalyticsService): AnalyticsService = analyticsService

    @Provides
    @Singleton
    @IntoMap
    @StringKey("logcat")
    fun provideMapLogcat(@LogcatLogger analyticsService: AnalyticsService): AnalyticsService = analyticsService

    @Provides
    @Singleton
    @IntoMap
    @StringKey("file")
    fun provideMapFile(@FileLogger analyticsService: AnalyticsService): AnalyticsService = analyticsService
}

@Module
@AssistedModule
@DisableInstallInCheck
interface AssistedFactories

@Component(modules = [DataBindingsModule::class])
@Singleton
interface DataComponent {
    fun notesRepository(): NotesRepository
    fun analyticsService(): AnalyticsService
    @LogcatLogger
    fun logcatAnalytics(): AnalyticsService
    @FileLogger
    fun fileAnalytics(): AnalyticsService
    fun remoteConfig(): RemoteConfig
    fun userSessionManager(): UserSessionManager
    fun noteFormatterFactory(): NoteFormatter.Factory
    fun multiboundAnalytics(): Set<@JvmSuppressWildcards AnalyticsService>
    fun analyticsMap(): Map<String, @JvmSuppressWildcards AnalyticsService>
    fun userComponentFactory(): UserComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appConfig(config: AppConfig): Builder

        @BindsInstance
        fun timeProvider(timeProvider: TimeProvider): Builder

        fun build(): DataComponent
    }
}
