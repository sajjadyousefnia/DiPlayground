package com.sajjady.di.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.api.NotesRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AnalyticsUploadService : Service() {

    @Inject lateinit var analyticsService: AnalyticsService
    @Inject lateinit var notesRepository: NotesRepository

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        analyticsService.logEvent("service_started_notes=${notesRepository.getAllNotes().size}")
    }
}
