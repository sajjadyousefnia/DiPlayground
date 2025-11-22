package com.sajjady.di.data.di

import com.sajjady.di.core.api.AnalyticsService
import com.sajjady.di.core.model.User
import dagger.BindsInstance
import dagger.Subcomponent

@UserScope
@Subcomponent
interface UserComponent {
    fun userAnalytics(): AnalyticsService
    fun currentUser(): User

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance user: User): UserComponent
    }
}
