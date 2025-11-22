package com.sajjady.di.data.di.module

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.di.qualifier.FileLogger
import com.sajjady.di.data.di.qualifier.LogcatLogger
import com.sajjady.di.data.impl.FileAnalyticsService
import com.sajjady.di.data.impl.LogcatAnalyticsService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@Module
abstract class AnalyticsModule {
    @Binds
    @LogcatLogger
    abstract fun bindLogcatAnalyticsService(service: LogcatAnalyticsService): AnalyticsService

    @Binds
    @FileLogger
    abstract fun bindFileAnalyticsService(service: FileAnalyticsService): AnalyticsService

    companion object {
        @Provides
        @IntoSet
        fun provideLogcatAnalytics(@LogcatLogger service: AnalyticsService): AnalyticsService = service

        @Provides
        @IntoSet
        fun provideFileAnalytics(@FileLogger service: AnalyticsService): AnalyticsService = service

        @Provides
        @IntoMap
        @StringKey("logcat")
        fun provideLogcatAnalyticsMap(@LogcatLogger service: AnalyticsService): AnalyticsService = service

        @Provides
        @IntoMap
        @StringKey("file")
        fun provideFileAnalyticsMap(@FileLogger service: AnalyticsService): AnalyticsService = service
    }
}
