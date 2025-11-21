package com.sajjady.di.core.api

import com.sajjady.di.core.model.User

interface UserSessionManager {
    fun login(user: User)
    fun logout()
    fun getCurrentUser(): User?
}
