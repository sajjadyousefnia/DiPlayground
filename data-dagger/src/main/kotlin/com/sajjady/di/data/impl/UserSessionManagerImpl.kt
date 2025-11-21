package com.sajjady.di.data.impl

import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.User
import com.sajjady.di.data.di.DataScope
import javax.inject.Inject

@DataScope
class UserSessionManagerImpl @Inject constructor() : UserSessionManager {

    private var currentUser: User? = null

    override fun login(user: User) {
        currentUser = user
    }

    override fun logout() {
        currentUser = null
    }

    override fun getCurrentUser(): User? = currentUser
}
