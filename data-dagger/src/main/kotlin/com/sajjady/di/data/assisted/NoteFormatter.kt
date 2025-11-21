package com.sajjady.di.data.assisted

import com.sajjady.di.core.model.Note
import com.sajjady.di.core.util.TimeProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NoteFormatter @AssistedInject constructor(
    private val timeProvider: TimeProvider,
    @Assisted private val note: Note
) {
    fun render(): String = buildString {
        appendLine(note.title)
        appendLine(note.content)
        append("Created ")
        append(timeProvider.now() - note.createdAt)
        append("ms ago")
    }

    @AssistedFactory
    fun interface Factory {
        fun create(note: Note): NoteFormatter
    }
}
