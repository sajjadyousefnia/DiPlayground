package com.sajjady.di.data.impl

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.model.Note
import com.sajjady.di.data.di.DataScope
import javax.inject.Inject

@DataScope
class InMemoryNotesRepository @Inject constructor(
    private val analyticsService: AnalyticsService
) : NotesRepository {

    private val notes = LinkedHashMap<String, Note>()

    override fun getAllNotes(): List<Note> = notes.values.toList()

    override fun getNoteById(id: String): Note? = notes[id]

    override fun addNote(note: Note) {
        notes[note.id] = note
        analyticsService.logEvent("note_added", mapOf("noteId" to note.id))
    }
}
