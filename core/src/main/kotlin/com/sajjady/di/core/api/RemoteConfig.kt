package com.sajjady.di.core.api

interface RemoteConfig {
    fun isFeatureEnabled(key: String): Boolean
    fun getString(key: String): String?
}
