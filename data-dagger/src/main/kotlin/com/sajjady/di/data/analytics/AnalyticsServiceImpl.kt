package com.sajjady.di.data.analytics

import com.sajjady.di.core.api.AnalyticsService

class LoggerAnalyticsService(
    override val name: String
) : AnalyticsService {
    override fun logEvent(event: String) {
        println("Analytics-$name: Logged $event")
    }
}
