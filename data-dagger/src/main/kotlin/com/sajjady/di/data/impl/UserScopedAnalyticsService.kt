package com.sajjady.di.data.impl

import com.sajjady.di.data.AnalyticsService
import com.sajjady.di.data.User
import com.sajjady.di.data.di.scope.UserScope
import javax.inject.Inject

@UserScope
class UserScopedAnalyticsService @Inject constructor(
    private val user: User,
    private val delegate: LogcatAnalyticsService
) : AnalyticsService {
    override fun logEvent(name: String, attributes: Map<String, Any?>) {
        val enriched = attributes + ("user" to user.id)
        delegate.logEvent("user-$name", enriched)
    }
}
