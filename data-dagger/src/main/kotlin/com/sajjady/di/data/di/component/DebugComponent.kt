package com.sajjady.di.data.di.component

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.di.scope.AppScope
import dagger.Component

@AppScope
@Component(dependencies = [AppComponent::class])
interface DebugComponent {
    fun analyticsService(): AnalyticsService
}
