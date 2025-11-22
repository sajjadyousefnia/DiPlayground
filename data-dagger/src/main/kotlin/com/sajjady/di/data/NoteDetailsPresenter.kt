package com.sajjady.di.data

import com.google.dagger.assisted.Assisted
import com.google.dagger.assisted.AssistedFactory
import com.google.dagger.assisted.AssistedInject
import javax.inject.Provider
import dagger.Lazy

class NoteDetailsPresenter @AssistedInject constructor(
    private val notesRepository: NotesRepository,
    private val timeProvider: Provider<TimeProvider>,
    private val analyticsService: Lazy<AnalyticsService>,
    @Assisted private val noteId: String
) {
    fun loadNote(): Note? {
        val note = notesRepository.getNoteById(noteId)
        analyticsService.get().logEvent(
            name = "note_details_opened",
            attributes = mapOf("noteId" to noteId, "at" to timeProvider.get().now().toString())
        )
        return note
    }

    @AssistedFactory
    interface Factory {
        fun create(noteId: String): NoteDetailsPresenter
    }
}
