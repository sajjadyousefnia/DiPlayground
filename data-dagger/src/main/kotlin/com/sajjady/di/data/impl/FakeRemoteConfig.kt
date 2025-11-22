package com.sajjady.di.data.impl

import com.sajjady.di.data.RemoteConfig
import javax.inject.Inject

class FakeRemoteConfig @Inject constructor() : RemoteConfig {
    private val strings = mutableMapOf<String, String>("welcome" to "Hello from remote")
    private val booleans = mutableMapOf<String, Boolean>("enabled" to true)

    override fun getString(key: String, defaultValue: String): String = strings[key] ?: defaultValue

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean = booleans[key] ?: defaultValue
}
