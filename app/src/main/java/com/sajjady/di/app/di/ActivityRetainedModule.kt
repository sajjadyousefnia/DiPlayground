package com.sajjady.di.app.di

import com.sajjady.di.ui.util.ActivityScopedLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object ActivityRetainedModule {

    @Provides
    @ActivityRetainedScoped
    fun provideActivityScopedLogger(): ActivityScopedLogger = ActivityScopedLogger()
}

