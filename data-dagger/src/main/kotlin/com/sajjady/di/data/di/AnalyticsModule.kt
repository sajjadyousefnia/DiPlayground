package com.sajjady.di.data.di

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.data.impl.CompositeAnalyticsService
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
class AnalyticsModule {

    @Provides
    @DataScope
    fun provideCompositeAnalyticsService(services: Set<@JvmSuppressWildcards AnalyticsService>): AnalyticsService =
        CompositeAnalyticsService(services)

    @Provides
    @DataScope
    fun provideAnalyticsService(compositeAnalyticsService: CompositeAnalyticsService): AnalyticsService =
        compositeAnalyticsService

    @Provides
    @IntoSet
    fun provideConsoleAnalytics(): AnalyticsService = CompositeAnalyticsService.ConsoleLogger

    @Provides
    @IntoSet
    fun provideLocalAnalytics(): AnalyticsService = CompositeAnalyticsService.InMemoryLogger
}
