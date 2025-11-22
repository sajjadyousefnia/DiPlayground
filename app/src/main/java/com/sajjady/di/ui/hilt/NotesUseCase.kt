package com.sajjady.di.ui.hilt

import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.model.Note
import com.sajjady.di.core.util.TimeProvider
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.UUID
import javax.inject.Inject

interface NotesUseCase {
    fun createNote(title: String, content: String): Note
    fun notes(): List<Note>
}

@ViewModelScoped
class DefaultNotesUseCase @Inject constructor(
    private val repository: NotesRepository,
    private val timeProvider: TimeProvider
) : NotesUseCase {
    override fun createNote(title: String, content: String): Note {
        val note = Note(UUID.randomUUID().toString(), title, content, timeProvider.now())
        repository.addNote(note)
        return note
    }

    override fun notes(): List<Note> = repository.getAllNotes()
}
