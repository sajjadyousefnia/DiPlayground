package com.sajjady.di.data.di.component

import com.sajjady.di.data.AnalyticsService
import dagger.Subcomponent

@Subcomponent
interface DebugComponent {
    fun analyticsService(): AnalyticsService

    @Subcomponent.Factory
    interface Factory {
        fun create(): DebugComponent
    }
}
