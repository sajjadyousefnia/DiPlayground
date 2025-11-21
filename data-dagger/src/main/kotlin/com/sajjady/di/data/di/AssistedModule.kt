package com.sajjady.di.data.di

import com.sajjady.di.data.assisted.NoteFormatter
import dagger.Module
import dagger.Provides

@Module
class AssistedModule {
    @Provides
    @DataScope
    fun provideNoteFormatterFactory(factory: NoteFormatter.Factory): NoteFormatter.Factory = factory
}
