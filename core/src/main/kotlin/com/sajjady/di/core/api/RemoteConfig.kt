package com.sajjady.di.core.api

import com.sajjady.di.core.model.AppConfig

interface RemoteConfig {
    suspend fun fetchLatest(): AppConfig

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean

    fun getString(key: String, defaultValue: String = ""): String
}
