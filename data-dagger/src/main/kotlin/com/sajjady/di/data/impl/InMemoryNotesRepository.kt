package com.sajjady.di.data.impl

import com.sajjady.di.data.Note
import com.sajjady.di.data.NotesRepository
import javax.inject.Inject

class InMemoryNotesRepository @Inject constructor() : NotesRepository {
    private val notes = linkedMapOf<String, Note>()

    override fun getNotes(): List<Note> = notes.values.toList()

    override fun getNoteById(noteId: String): Note? = notes[noteId]

    override fun addNote(note: Note) {
        notes[note.id] = note
    }
}
