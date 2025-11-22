package com.sajjady.di.ui.fragment

import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltNotesViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {
    fun notes(): List<Note> = repository.getAllNotes()
}
