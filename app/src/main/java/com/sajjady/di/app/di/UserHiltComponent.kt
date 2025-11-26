package com.sajjady.di.app.di

import javax.inject.Scope
import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.DefineComponent.Builder
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class UserScope

@DefineComponent(parent = SingletonComponent::class)
@UserScope
interface UserComponent {
    @DefineComponent.Builder
    interface Builder {
        fun build(): UserComponent
    }
}

@Module
@DisableInstallInCheck
object UserHiltModule {
    @Provides
    @UserScope
    fun provideUserMarker(): Any = Any()
}
