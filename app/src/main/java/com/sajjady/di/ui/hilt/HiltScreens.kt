package com.sajjady.di.ui.hilt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HiltBasicsScreen(viewModel: HiltBasicsViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) { viewModel.logScreenOpen() }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Hilt Basics", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        viewModel.notes().forEach { note ->
            Text("${note.title}: ${note.content}")
        }
    }
}

@Composable
fun HiltScopesScreen(viewModel: HiltScopesViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Scopes", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        viewModel.snapshot().forEach { Text(it) }
        Button(onClick = { viewModel.addNote() }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Add scoped note")
        }
    }
}

@Composable
fun HiltQualifiersScreen(viewModel: HiltQualifiersViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Qualifiers", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        viewModel.descriptions().forEach { Text(it) }
    }
}

@Composable
fun HiltMultibindingScreen(viewModel: HiltMultibindingViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Multibindings", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Set size: ${viewModel.setSize()}")
        Text("Map keys: ${viewModel.mapKeys().joinToString()}")
    }
}

@Composable
fun HiltCustomComponentScreen(viewModel: HiltCustomComponentViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Custom component", style = MaterialTheme.typography.headlineMedium)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text(viewModel.status.value)
        Button(onClick = { viewModel.login() }, modifier = Modifier.padding(top = 12.dp)) { Text("Login user") }
        Button(onClick = { viewModel.logout() }, modifier = Modifier.padding(top = 8.dp)) { Text("Logout") }
    }
}
