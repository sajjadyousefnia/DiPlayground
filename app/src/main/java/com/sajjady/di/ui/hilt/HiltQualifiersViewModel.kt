package com.sajjady.di.ui.hilt

import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.data.di.FileLogger
import com.sajjady.di.data.di.LogcatLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltQualifiersViewModel @Inject constructor(
    @LogcatLogger private val logcatAnalytics: AnalyticsService,
    @FileLogger private val fileAnalytics: AnalyticsService
) : ViewModel() {
    fun descriptions(): List<String> = listOf(
        "Logcat: ${logcatAnalytics.name} (hash=${System.identityHashCode(logcatAnalytics)})",
        "File: ${fileAnalytics.name} (hash=${System.identityHashCode(fileAnalytics)})"
    )
}
