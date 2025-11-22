package com.sajjady.di.legacy.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sajjady.di.core.model.Note;
import com.sajjady.di.data.assisted.NoteFormatter;
import com.sajjady.di.data.di.DataComponent;
import com.sajjady.di.data.di.DataComponentProvider;
import com.sajjady.di.legacy.R;
import com.sajjady.di.legacy.di.DaggerLegacyComponent;
import com.sajjady.di.legacy.di.LegacyComponent;
import com.sajjady.di.legacy.di.LegacyModule;

import java.util.UUID;

import javax.inject.Inject;

public class LegacyActivity extends AppCompatActivity implements LegacyComponentOwner {

    private LegacyComponent legacyComponent;

    @Inject
    NoteFormatter.Factory noteFormatterFactory;

    @Inject
    String welcomeMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataComponent dataComponent = ((DataComponentProvider) getApplication()).dataComponent();
        legacyComponent = DaggerLegacyComponent.builder()
                .dataComponent(dataComponent)
                .legacyModule(new LegacyModule())
                .build();
        legacyComponent.inject(this);

        setContentView(R.layout.activity_legacy);

        TextView titleView = findViewById(R.id.legacyTitle);
        TextView bodyView = findViewById(R.id.legacyBody);

        Note sampleNote = new Note(
                UUID.randomUUID().toString(),
                "Legacy Dagger Note",
                "Showing classical Activity/Fragment injection.",
                System.currentTimeMillis() - 5000
        );

        NoteFormatter formatter = noteFormatterFactory.create(sampleNote);
        titleView.setText(welcomeMessage);
        bodyView.setText(formatter.render());

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.legacyFragmentContainer, new LegacyFragment())
                    .commit();
        }
    }

    @Override
    public LegacyComponent legacyComponent() {
        return legacyComponent;
    }
}
