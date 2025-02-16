package com.orkhontech.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.orkhontech.notesapp.common.presentation.navigation.NotesNavHost
import com.orkhontech.notesapp.common.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                val navHostController = rememberNavController()

                Surface(modifier = Modifier.fillMaxSize()) {
                    NotesNavHost(navController = navHostController)
                }
            }
        }
    }
}
