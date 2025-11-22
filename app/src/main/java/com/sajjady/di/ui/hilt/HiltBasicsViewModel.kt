package com.sajjady.di.ui.hilt

import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltBasicsViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    private val analyticsService: AnalyticsService,
    private val remoteConfig: RemoteConfig
) : ViewModel() {

    fun notes(): List<Note> = notesRepository.getAllNotes()

    fun logScreenOpen() {
        analyticsService.logEvent("hilt_basics_open_${remoteConfig.getString("environment")}")
    }
}
