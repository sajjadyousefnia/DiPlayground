package com.sajjady.di.legacy.di;

import androidx.fragment.app.FragmentActivity;

import com.sajjady.di.data.AnalyticsService;
import com.sajjady.di.data.NotesRepository;
import com.sajjady.di.data.di.qualifier.LogcatLogger;
import com.sajjady.di.legacy.ui.LegacyLogger;
import com.sajjady.di.legacy.ui.LegacyNotesActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LegacyActivityModule {

    @Provides
    @LegacyActivityScope
    LegacyNotesActivity provideActivity(LegacyNotesActivity activity) {
        return activity;
    }

    @Provides
    @LegacyActivityScope
    FragmentActivity provideFragmentActivity(LegacyNotesActivity activity) {
        return activity;
    }

    @Provides
    @LegacyActivityScope
    LegacyLogger provideLegacyLogger(@LogcatLogger AnalyticsService analyticsService, NotesRepository notesRepository) {
        return new LegacyLogger(analyticsService, notesRepository);
    }
}
