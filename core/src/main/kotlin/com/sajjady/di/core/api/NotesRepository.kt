package com.sajjady.di.core.api

import com.sajjady.di.core.model.Note

interface NotesRepository {
    fun getAllNotes(): List<Note>
    fun getNote(id: String): Note?
    fun addNote(note: Note)
}
