package com.sajjady.di.data.impl

import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.data.di.DataScope
import javax.inject.Inject

@DataScope
class RemoteConfigImpl @Inject constructor(
    private val appConfig: AppConfig
) : RemoteConfig {
    override fun getBoolean(key: String): Boolean? = appConfig.featureFlags[key]

    override fun getString(key: String): String? = when (key) {
        "environment" -> appConfig.environment
        "apiBaseUrl" -> appConfig.apiBaseUrl
        else -> null
    }
}
