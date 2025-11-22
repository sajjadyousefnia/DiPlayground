package com.sajjady.di.ui.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScreenNavigator {
    private val _currentRoute = MutableStateFlow(HiltDestination.Home.route)
    val currentRoute = _currentRoute.asStateFlow()

    fun navigate(destination: HiltDestination) {
        _currentRoute.value = destination.route
    }
}

enum class HiltDestination(val route: String) {
    Home("home"),
    Basics("basics"),
    Scopes("scopes"),
    Qualifiers("qualifiers"),
    Multibinding("multibinding"),
    CustomComponent("custom"),
    DaggerPlayground("dagger"),
    Legacy("legacy")
}
