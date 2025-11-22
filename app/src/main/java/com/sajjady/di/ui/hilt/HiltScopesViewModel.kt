package com.sajjady.di.ui.hilt

import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.ui.util.ActivityScopedLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltScopesViewModel @Inject constructor(
    private val analyticsService: AnalyticsService,
    private val logger: ActivityScopedLogger,
    private val notesUseCase: NotesUseCase
) : ViewModel() {
    private val id = System.identityHashCode(this)

    fun snapshot(): List<String> = listOf(
        "ViewModel hash=$id",
        "Analytics hash=${System.identityHashCode(analyticsService)}",
        "Logger hash=${System.identityHashCode(logger)}",
        "UseCase hash=${System.identityHashCode(notesUseCase)}"
    )

    fun addNote() {
        notesUseCase.createNote("Scoped", "Created from scopes screen")
        analyticsService.logEvent("scope_add_note")
        logger.log("Added from scopes")
    }
}
