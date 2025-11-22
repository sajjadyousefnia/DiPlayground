package com.sajjady.di.data.di.component

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.User
import com.sajjady.di.data.UserSessionManager
import com.sajjady.di.data.di.module.UserModule
import com.sajjady.di.data.di.qualifier.UserAnalytics
import com.sajjady.di.data.di.scope.UserScope
import dagger.BindsInstance
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = [UserModule::class])
interface UserComponent {
    fun user(): User
    fun userSessionManager(): UserSessionManager
    @UserAnalytics
    fun userScopedAnalyticsService(): AnalyticsService

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance user: User): UserComponent
    }
}
