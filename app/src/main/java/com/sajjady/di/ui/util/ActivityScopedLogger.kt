package com.sajjady.di.ui.util

class ActivityScopedLogger {
    private val logs = mutableListOf<String>()

    fun log(message: String) {
        logs += message
    }

    fun history(): List<String> = logs.toList()
}
