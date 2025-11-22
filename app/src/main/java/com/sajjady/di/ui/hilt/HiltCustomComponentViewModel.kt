package com.sajjady.di.ui.hilt

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sajjady.di.core.api.UserSessionManager
import com.sajjady.di.core.model.User
import com.sajjady.di.data.di.DataComponent
import com.sajjady.di.data.di.UserComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HiltCustomComponentViewModel @Inject constructor(
    private val userSessionManager: UserSessionManager,
    private val dataComponent: DataComponent
) : ViewModel() {
    private var userComponent: UserComponent? = null
    val status = mutableStateOf("Logged out")

    fun login() {
        val user = User("hilt-user", "Hilt User", true)
        userSessionManager.login(user)
        userComponent = dataComponent.userComponentFactory().create(user)
        status.value = "Logged in as ${user.name} with analytics ${userComponent?.userAnalytics()?.name}"
    }

    fun logout() {
        userSessionManager.logout()
        userComponent = null
        status.value = "Logged out"
    }
}
