package com.sajjady.di.data.impl

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.data.di.DataScope
import javax.inject.Inject

@DataScope
class CompositeAnalyticsService @Inject constructor(
    private val services: Set<@JvmSuppressWildcards AnalyticsService>
) : AnalyticsService {

    override fun logEvent(name: String, properties: Map<String, String>) {
        services.forEach { it.logEvent(name, properties) }
    }

    object ConsoleLogger : AnalyticsService {
        override fun logEvent(name: String, properties: Map<String, String>) {
            println("[ConsoleAnalytics] $name -> ${properties.ifEmpty { mapOf("status" to "ok") }}")
        }
    }

    object InMemoryLogger : AnalyticsService {
        private val events = mutableListOf<String>()
        override fun logEvent(name: String, properties: Map<String, String>) {
            events += "${name}:${properties.size}"
        }

        fun snapshot(): List<String> = events.toList()
    }
}
