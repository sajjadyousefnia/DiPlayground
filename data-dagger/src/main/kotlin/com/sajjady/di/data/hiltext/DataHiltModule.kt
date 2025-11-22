package com.sajjady.di.data.hiltext

import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.model.AppConfig
import com.sajjady.di.data.config.FakeRemoteConfig
import com.sajjady.di.data.repo.InMemoryNotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataHiltModule {
    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository = InMemoryNotesRepository()

    @Provides
    @Singleton
    fun provideRemoteConfig(appConfig: AppConfig): RemoteConfig = FakeRemoteConfig(appConfig)
}
