package com.sajjady.di.data.session

import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.User
import java.util.concurrent.atomic.AtomicReference

class UserSessionManagerImpl : UserSessionManager {
    private val userRef = AtomicReference<User?>()

    override fun login(user: User) {
        userRef.set(user)
    }

    override fun logout() {
        userRef.set(null)
    }

    override fun getCurrentUser(): User? = userRef.get()
}
