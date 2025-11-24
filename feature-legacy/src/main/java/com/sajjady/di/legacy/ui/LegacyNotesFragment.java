package com.sajjady.di.legacy.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sajjady.di.data.AnalyticsService;
import com.sajjady.di.data.Note;
import com.sajjady.di.data.NotesRepository;
import com.sajjady.di.data.UserSessionManager;
import com.sajjady.di.legacy.R;

import java.util.Collections;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class LegacyNotesFragment extends Fragment {

    @Inject
    NotesRepository notesRepository;

    @Inject
    AnalyticsService analyticsService;

    @Inject
    UserSessionManager userSessionManager;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof LegacyComponentProvider) {
            ((LegacyComponentProvider) context).legacyActivityComponent().inject(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_legacy_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.notes_text);
        String notes = notesRepository.getNotes().stream()
                .map(Note::getTitle)
                .collect(Collectors.joining(", "));
        textView.setText(notes);
        analyticsService.logEvent("legacy_fragment_loaded", Collections.emptyMap());
    }
}
