package com.sajjady.di.data.impl

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.TimeProvider
import java.io.File
import javax.inject.Inject

class FileAnalyticsService @Inject constructor(
    private val timeProvider: TimeProvider
) : AnalyticsService {
    private val logFile: File = File("analytics.log")

    override fun logEvent(name: String, attributes: Map<String, Any?>) {
        val timestamp = timeProvider.now()
        logFile.appendText("[File][$timestamp] $name -> $attributes\n")
    }
}
