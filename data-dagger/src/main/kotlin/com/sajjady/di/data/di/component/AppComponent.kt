package com.sajjady.di.data.di.component

import com.sajjady.di.data.*
import com.sajjady.di.data.di.module.*
import com.sajjady.di.data.di.qualifier.LogcatLogger
import com.sajjady.di.data.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.Lazy

@AppScope
@Component(
    modules = [
        CoreModule::class,
        AnalyticsModule::class,
        ConfigModule::class,
        OptionalModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {
    fun notesRepository(): NotesRepository
    fun remoteConfig(): RemoteConfig
    fun timeProvider(): TimeProvider
    fun userSessionManager(): UserSessionManager

    @LogcatLogger
    fun defaultAnalytics(): AnalyticsService

    fun analyticsServices(): Set<@JvmSuppressWildcards AnalyticsService>
    fun analyticsServiceMap(): Map<String, @JvmSuppressWildcards AnalyticsService>
    fun optionalUser(): java.util.Optional<User>
    fun initializer(): Initializer
    fun noteDetailsPresenterFactory(): NoteDetailsPresenter.Factory

    fun userComponentFactory(): UserComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: ApplicationContext,
            @BindsInstance appConfig: AppConfig
        ): AppComponent
    }
}
