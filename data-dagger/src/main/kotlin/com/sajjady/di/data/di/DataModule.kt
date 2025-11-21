package com.sajjady.di.data.di

import com.sajjady.di.core.api.NotesRepository
import com.sajjady.di.core.api.RemoteConfig
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.data.impl.InMemoryNotesRepository
import com.sajjady.di.data.impl.RemoteConfigImpl
import com.sajjady.di.data.impl.UserSessionManagerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    @DataScope
    abstract fun bindNotesRepository(impl: InMemoryNotesRepository): NotesRepository

    @Binds
    @DataScope
    abstract fun bindRemoteConfig(impl: RemoteConfigImpl): RemoteConfig

    @Binds
    @DataScope
    abstract fun bindUserSessionManager(impl: UserSessionManagerImpl): UserSessionManager
}
