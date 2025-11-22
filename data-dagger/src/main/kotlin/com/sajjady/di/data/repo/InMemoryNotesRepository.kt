package com.sajjady.di.data.repo

import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.model.Note
import java.util.concurrent.CopyOnWriteArrayList

class InMemoryNotesRepository : NotesRepository {
    private val notes = CopyOnWriteArrayList<Note>()

    override fun getAllNotes(): List<Note> = notes.toList()

    override fun getNote(id: String): Note? = notes.firstOrNull { it.id == id }

    override fun addNote(note: Note) {
        notes += note
    }
}
