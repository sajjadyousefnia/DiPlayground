package com.sajjady.di.core.model

data class AppConfig(
    val environment: String,
    val apiBaseUrl: String,
    val featureFlags: Map<String, Boolean>,
)
