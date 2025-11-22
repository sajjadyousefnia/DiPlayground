package com.sajjady.di.app.di

import com.sajjady.di.ui.navigation.ScreenNavigator
import com.sajjady.di.ui.util.ActivityScopedLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    @ActivityScoped
    fun provideNavigator(): ScreenNavigator = ScreenNavigator()

    @Provides
    @ActivityScoped
    fun provideLogger(): ActivityScopedLogger = ActivityScopedLogger()
}
