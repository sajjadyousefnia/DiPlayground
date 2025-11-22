package com.sajjady.di.data

import java.time.Instant

/** Basic domain models used across the data layer. */
data class Note(
    val id: String,
    val title: String,
    val body: String
)

data class User(
    val id: String,
    val name: String
)

data class AppConfig(
    val flavor: String,
    val isDebug: Boolean
)

/** Wrapper used to represent an application context for the JVM-only Dagger graph. */
data class ApplicationContext(val description: String = "app")

interface NotesRepository {
    fun getNotes(): List<Note>
    fun getNoteById(noteId: String): Note?
    fun addNote(note: Note)
}

interface RemoteConfig {
    fun getString(key: String, defaultValue: String = ""): String
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean
}

interface AnalyticsService {
    fun logEvent(name: String, attributes: Map<String, Any?> = emptyMap())
}

interface UserSessionManager {
    fun currentUser(): User?
    fun updateUser(user: User?)
}

interface TimeProvider {
    fun now(): Instant
}
