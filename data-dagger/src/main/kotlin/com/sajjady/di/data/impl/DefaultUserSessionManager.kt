package com.sajjady.di.data.impl

import com.sajjady.di.data.User
import com.sajjady.di.data.UserSessionManager
import java.util.Optional
import javax.inject.Inject
import javax.inject.Singleton

class DefaultUserSessionManager @Inject constructor() : UserSessionManager {
    private var user: User? = null

    override fun currentUser(): User? = user

    override fun updateUser(user: User?) {
        this.user = user
    }

    fun asOptional(): Optional<User> = Optional.ofNullable(user)
}
