package com.sajjady.di.ui.hilt

import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.AnalyticsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltMultibindingViewModel @Inject constructor(
    private val analyticsSet: Set<@JvmSuppressWildcards AnalyticsService>,
    private val analyticsMap: Map<String, @JvmSuppressWildcards AnalyticsService>
) : ViewModel() {
    fun setSize(): Int = analyticsSet.size
    fun mapKeys(): Set<String> = analyticsMap.keys
}
