package com.sajjady.di.app.di

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.model.User
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import dagger.hilt.DefineComponent.Builder
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class UserScope

@DefineComponent(parent = SingletonComponent::class)
@UserScope
interface UserComponent {
    fun analyticsService(): AnalyticsService
    fun user(): User

    @DefineComponent.Builder
    interface Builder {
        fun user(@BindsInstance user: User): Builder
        fun build(): UserComponent
    }
}

@Module
@DisableInstallInCheck
object UserHiltModule {
    @Provides
    @UserScope
    fun provideUserAnalytics(): AnalyticsService = object : AnalyticsService {
        override val name: String = "user"
        override fun logEvent(event: String) {
            // no-op for demo
        }
    }
}
