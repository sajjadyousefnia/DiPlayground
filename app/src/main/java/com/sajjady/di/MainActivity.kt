package com.sajjady.di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sajjady.di.ui.hilt.HiltBasicsScreen
import com.sajjady.di.ui.hilt.HiltCustomComponentScreen
import com.sajjady.di.ui.hilt.HiltMultibindingScreen
import com.sajjady.di.ui.hilt.HiltQualifiersScreen
import com.sajjady.di.ui.hilt.HiltScopesScreen
import com.sajjady.di.ui.navigation.HiltDestination
import com.sajjady.di.ui.navigation.ScreenNavigator
import com.sajjady.di.ui.screens.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface { DiPlaygroundNav() }
            }
        }
    }
}

@Composable
fun DiPlaygroundNav() {
    val navController = rememberNavController()
    val navigator = remember { ScreenNavigator() }
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: HiltDestination.Home.route

    NavHost(navController = navController, startDestination = HiltDestination.Home.route) {
        composable(HiltDestination.Home.route) {
            HomeScreen(currentRoute) { destination ->
                navigator.navigate(destination)
                navController.navigate(destination.route)
            }
        }
        composable(HiltDestination.Basics.route) {
            HiltBasicsScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.Scopes.route) {
            HiltScopesScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.Qualifiers.route) {
            HiltQualifiersScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.Multibinding.route) {
            HiltMultibindingScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.CustomComponent.route) {
            HiltCustomComponentScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.DaggerPlayground.route) {
            // Placeholder for dagger demo
            HiltBasicsScreen(viewModel = hiltViewModel())
        }
        composable(HiltDestination.Legacy.route) {
            HiltBasicsScreen(viewModel = hiltViewModel())
        }
    }
}
