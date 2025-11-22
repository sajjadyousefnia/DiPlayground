package com.sajjady.di.data.di

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.core.util.TimeProvider
import com.sajjady.di.data.assisted.NoteFormatter
import dagger.BindsInstance
import dagger.Component

@DataScope
@Component(modules = [DataModule::class, AnalyticsModule::class, AssistedModule::class])
interface DataComponent {

    fun notesRepository(): NotesRepository
    fun analyticsService(): AnalyticsService
    fun remoteConfig(): RemoteConfig
    fun userSessionManager(): UserSessionManager
    fun noteFormatterFactory(): NoteFormatter.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appConfig(config: AppConfig): Builder

        @BindsInstance
        fun timeProvider(timeProvider: TimeProvider): Builder

        fun build(): DataComponent
    }
}
