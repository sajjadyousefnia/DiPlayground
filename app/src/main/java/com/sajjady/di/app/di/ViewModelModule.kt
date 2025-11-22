package com.sajjady.di.app.di

import com.sajjady.di.data.repo.InMemoryNotesRepository
import com.sajjady.di.ui.hilt.DefaultNotesUseCase
import com.sajjady.di.ui.hilt.NotesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    @ViewModelScoped
    abstract fun bindNotesUseCase(impl: DefaultNotesUseCase): NotesUseCase
}
