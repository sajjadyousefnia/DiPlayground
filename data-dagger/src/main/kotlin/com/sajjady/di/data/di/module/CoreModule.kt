package com.sajjady.di.data.di.module

import com.sajjady.di.data.NotesRepository
import com.sajjady.di.data.TimeProvider
import com.sajjady.di.data.UserSessionManager
import com.sajjady.di.data.di.scope.AppScope
import com.sajjady.di.data.impl.DefaultUserSessionManager
import com.sajjady.di.data.impl.InMemoryNotesRepository
import com.sajjady.di.data.impl.SystemTimeProvider
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class CoreModule {
    @Binds
    @AppScope
    abstract fun bindNotesRepository(impl: InMemoryNotesRepository): NotesRepository

    @Binds
    @AppScope
    abstract fun bindUserSessionManager(impl: DefaultUserSessionManager): UserSessionManager

    @Binds
    @Reusable
    abstract fun bindTimeProvider(impl: SystemTimeProvider): TimeProvider
}
