package com.sajjady.di.core.api

/** Simple analytics contract used across the samples. */
interface AnalyticsService {
    val name: String
    fun logEvent(event: String)
}
