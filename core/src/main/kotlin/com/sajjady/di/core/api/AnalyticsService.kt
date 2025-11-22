package com.sajjady.di.core.api

interface AnalyticsService {
    fun logEvent(name: String, properties: Map<String, String> = emptyMap())
}
