package com.sajjady.di.core.api

import com.sajjady.di.core.model.Note

interface NotesRepository {
    fun getAllNotes(): List<Note>
    fun getNoteById(id: String): Note?
    fun addNote(note: Note)
}
