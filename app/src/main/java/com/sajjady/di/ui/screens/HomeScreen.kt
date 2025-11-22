package com.sajjady.di.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sajjady.di.ui.navigation.HiltDestination

@Composable
fun HomeScreen(currentRoute: String, onNavigate: (HiltDestination) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Hilt Playground", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        HiltDestination.values().forEach { destination ->
            Text(
                text = "• ${destination.name} (${destination.route})",
                modifier = Modifier
                    .clickable { onNavigate(destination) }
                    .padding(vertical = 8.dp),
                style = if (destination.route == currentRoute) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge
            )
        }
    }
}
