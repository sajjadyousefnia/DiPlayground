package com.sajjady.di.data.di.module

import com.sajjady.di.data.AppConfig
import com.sajjady.di.data.RemoteConfig
import com.sajjady.di.data.impl.FakeRemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Named

@Module
@DisableInstallInCheck
object ConfigModule {
    @Provides
    fun provideRemoteConfig(): RemoteConfig = FakeRemoteConfig()

    @Provides
    @Named("debug")
    fun provideDebugEndpoint(config: AppConfig): String = "https://debug.api/${config.flavor}"

    @Provides
    @Named("release")
    fun provideReleaseEndpoint(config: AppConfig): String = "https://release.api/${config.flavor}"
}
