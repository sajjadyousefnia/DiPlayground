package com.sajjady.di.data.config

import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.model.AppConfig

class FakeRemoteConfig(
    private val config: AppConfig
) : RemoteConfig {
    override fun getString(key: String): String? = when (key) {
        "environment" -> config.environment
        "apiBaseUrl" -> config.apiBaseUrl
        else -> null
    }

    override fun getBoolean(key: String): Boolean? = config.featureFlags[key]
}
