package com.sajjady.di.data.impl

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.data.di.DataScope
import javax.inject.Inject

@DataScope
class CompositeAnalyticsService @Inject constructor(
    private val services: Set<@JvmSuppressWildcards AnalyticsService>
) : AnalyticsService {

    override val name: String = "composite"

    override fun logEvent(event: String) {
        services.forEach { it.logEvent(event) }
    }

    object ConsoleLogger : AnalyticsService {
        override val name: String = "console"

        override fun logEvent(event: String) {
            println("[ConsoleAnalytics] $event")
        }
    }

    object InMemoryLogger : AnalyticsService {
        override val name: String = "memory"
        private val events = mutableListOf<String>()

        override fun logEvent(event: String) {
            events += event
        }

        fun snapshot(): List<String> = events.toList()
    }
}
