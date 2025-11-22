package com.sajjady.di.core.api

import com.sajjady.di.core.model.Note

interface NotesRepository {
    suspend fun getNotes(): List<Note>

    suspend fun getNote(id: String): Note?

    suspend fun upsert(note: Note): Note

    suspend fun delete(id: String)
}
