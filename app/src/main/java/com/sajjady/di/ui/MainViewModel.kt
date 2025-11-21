package com.sajjady.di.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.Note
import com.sajjady.di.core.model.User
import com.sajjady.di.core.util.TimeProvider
import com.sajjady.di.data.assisted.NoteFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    private val userSessionManager: UserSessionManager,
    private val noteFormatterFactory: NoteFormatter.Factory,
    private val remoteConfig: RemoteConfig,
    private val analyticsService: AnalyticsService,
    private val timeProvider: TimeProvider
) : ViewModel() {

    val notes = mutableStateOf(notesRepository.getAllNotes())
    val environment = mutableStateOf(remoteConfig.getString("environment") ?: "unknown")

    init {
        if (userSessionManager.getCurrentUser() == null) {
            userSessionManager.login(User("compose", "Compose User", true))
        }
    }

    fun addSampleNote() {
        val note = Note(
            id = UUID.randomUUID().toString(),
            title = "Hilt-powered note",
            content = "Created via Compose screen using the shared Dagger data graph.",
            createdAt = timeProvider.now()
        )
        notesRepository.addNote(note)
        analyticsService.logEvent("compose_note_added")
        notes.value = notesRepository.getAllNotes()
    }

    fun format(note: Note): String = noteFormatterFactory.create(note).render()
}
