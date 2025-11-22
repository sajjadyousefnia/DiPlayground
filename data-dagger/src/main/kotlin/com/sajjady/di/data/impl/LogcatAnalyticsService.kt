package com.sajjady.di.data.impl

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.TimeProvider
import javax.inject.Inject

class LogcatAnalyticsService @Inject constructor(
    private val timeProvider: TimeProvider
) : AnalyticsService {
    override fun logEvent(name: String, attributes: Map<String, Any?>) {
        val timestamp = timeProvider.now()
        println("[Logcat][$timestamp] $name -> $attributes")
    }
}
