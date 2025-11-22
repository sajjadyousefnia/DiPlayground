package com.sajjady.di.core.model

data class AppConfig(
    val appVersion: String,
    val featureFlags: Map<String, Boolean> = emptyMap(),
    val minimumSupportedVersion: String? = null,
)
