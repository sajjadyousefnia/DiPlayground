package com.sajjady.di.data.assisted

import com.sajjady.di.core.model.Note
import com.sajjady.di.core.util.TimeProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoteFormatter @AssistedInject constructor(
    private val timeProvider: TimeProvider,
    @Assisted private val note: Note
) {
    fun render(): String {
        val formatter = SimpleDateFormat("HH:mm:ss", Locale.US)
        val created = formatter.format(Date(note.createdAt))
        val now = formatter.format(Date(timeProvider.now()))
        return "${note.title} (created $created, now $now)"
    }

    @AssistedFactory
    interface Factory {
        fun create(note: Note): NoteFormatter
    }
}
