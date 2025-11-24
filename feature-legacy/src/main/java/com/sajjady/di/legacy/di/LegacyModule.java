package com.sajjady.di.legacy.di;

import com.sajjady.di.data.assisted.NoteFormatter;
import com.sajjady.di.data.di.DataComponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LegacyModule {

    @Provides
    @LegacyScope
    String provideWelcomeMessage() {
        return "Legacy Dagger Activity";
    }

    @Provides
    @LegacyScope
    @Named("legacyNoteFormatter")
    NoteFormatter.Factory provideNoteFormatterFactory(DataComponent dataComponent) {
        return dataComponent.noteFormatterFactory();
    }
}
