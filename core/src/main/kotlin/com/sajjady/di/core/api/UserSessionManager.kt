package com.sajjady.di.core.api

import com.sajjady.di.core.model.User

interface UserSessionManager {
    suspend fun signIn(user: User)

    suspend fun signOut()

    fun getCurrentUser(): User?

    fun isSignedIn(): Boolean = getCurrentUser() != null
}
