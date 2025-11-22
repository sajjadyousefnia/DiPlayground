package com.sajjady.di.core.model

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: Long
)

data class User(
    val id: String,
    val name: String,
    val isPremium: Boolean
)

data class AppConfig(
    val environment: String,
    val apiBaseUrl: String,
    val featureFlags: Map<String, Boolean>
)
