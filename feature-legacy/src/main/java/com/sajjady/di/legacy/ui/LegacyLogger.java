package com.sajjady.di.legacy.ui;

import com.sajjady.di.data.AnalyticsService;
import com.sajjady.di.data.NotesRepository;
import com.sajjady.di.data.Note;

import java.util.List;

public class LegacyLogger {
    private final AnalyticsService analyticsService;
    private final NotesRepository notesRepository;

    public LegacyLogger(AnalyticsService analyticsService, NotesRepository notesRepository) {
        this.analyticsService = analyticsService;
        this.notesRepository = notesRepository;
    }

    public void logNotesDisplayed() {
        List<Note> notes = notesRepository.getNotes();
        analyticsService.logEvent("legacy_notes_displayed", java.util.Map.of("count", notes.size()));
    }
}
