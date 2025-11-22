package com.sajjady.di.legacy.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.sajjady.di.data.AnalyticsService;
import com.sajjady.di.data.Note;
import com.sajjady.di.data.NotesRepository;
import com.sajjady.di.data.UserSessionManager;
import com.sajjady.di.data.di.component.AppComponent;
import com.sajjady.di.legacy.LegacyApplication;
import com.sajjady.di.legacy.R;
import com.sajjady.di.legacy.di.DaggerLegacyActivityComponent;
import com.sajjady.di.legacy.di.LegacyActivityComponent;

import javax.inject.Inject;

public class LegacyNotesActivity extends AppCompatActivity implements LegacyComponentProvider {

    @Inject
    NotesRepository notesRepository;

    @Inject
    AnalyticsService analyticsService;

    @Inject
    UserSessionManager userSessionManager;

    @Inject
    LegacyLogger legacyLogger;

    private LegacyActivityComponent legacyActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legacy_notes);
        buildComponent();
        legacyActivityComponent.inject(this);

        seedNotes();
        attachFragment();
        setupButton();
    }

    private void buildComponent() {
        AppComponent appComponent = ((LegacyApplication) getApplication()).getAppComponent();
        legacyActivityComponent = DaggerLegacyActivityComponent.builder()
                .appComponent(appComponent)
                .activity(this)
                .build();
    }

    private void seedNotes() {
        notesRepository.addNote(new Note("1", "Legacy", "Injected from Activity"));
    }

    private void attachFragment() {
        if (getSupportFragmentManager().findFragmentByTag("legacy") == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new LegacyNotesFragment(), "legacy");
            transaction.commitNow();
        }
    }

    private void setupButton() {
        Button button = findViewById(R.id.log_event_button);
        button.setOnClickListener(v -> {
            legacyLogger.logNotesDisplayed();
            analyticsService.logEvent("legacy_button_clicked");
        });
    }

    @Override
    public LegacyActivityComponent legacyActivityComponent() {
        return legacyActivityComponent;
    }
}
