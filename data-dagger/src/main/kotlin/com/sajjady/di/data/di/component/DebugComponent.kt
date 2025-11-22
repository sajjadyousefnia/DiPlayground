package com.sajjady.di.data.di.component

import com.sajjady.di.data.AnalyticsService
import dagger.Component

@Component(dependencies = [AppComponent::class])
interface DebugComponent {
    fun analyticsService(): AnalyticsService
}
