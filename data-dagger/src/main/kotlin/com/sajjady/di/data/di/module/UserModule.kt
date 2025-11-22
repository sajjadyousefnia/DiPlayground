package com.sajjady.di.data.di.module

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.di.scope.UserScope
import com.sajjady.di.data.impl.UserScopedAnalyticsService
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@Module
@DisableInstallInCheck
abstract class UserModule {
    @Binds
    @UserScope
    abstract fun bindUserScopedAnalyticsService(service: UserScopedAnalyticsService): AnalyticsService
}
