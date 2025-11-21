package com.sajjady.di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sajjady.di.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiPlaygroundApp(viewModel)
        }
    }
}

@Composable
fun DiPlaygroundApp(viewModel: MainViewModel) {
    val notes by viewModel.notes
    val environment by viewModel.environment

    MaterialTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = "DI Playground", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Environment: $environment", style = MaterialTheme.typography.bodyLarge)
                Button(onClick = { viewModel.addSampleNote() }) {
                    Text("Add sample note")
                }
                Divider()
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(notes) { note ->
                        Text(text = viewModel.format(note), style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}
