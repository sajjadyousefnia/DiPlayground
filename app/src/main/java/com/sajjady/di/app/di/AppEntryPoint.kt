package com.sajjady.di.app.di

import com.sajjady.di.core.api.AnalyticsService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppEntryPoint {
    fun analyticsService(): AnalyticsService
}
