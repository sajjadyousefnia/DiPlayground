package com.sajjady.di.core.api

interface RemoteConfig {
    fun getString(key: String): String?
    fun getBoolean(key: String): Boolean?
}
