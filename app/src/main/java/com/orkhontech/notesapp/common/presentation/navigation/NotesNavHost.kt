package com.orkhontech.notesapp.common.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.orkhontech.notesapp.common.presentation.screens.noteAdd.NoteAddScreen
import com.orkhontech.notesapp.common.presentation.screens.noteEdit.NoteEditScreen
import com.orkhontech.notesapp.common.presentation.screens.noteList.NoteListScreen

@Composable
fun NotesNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.NoteListScreen,
    ) {
        composable<Screens.NoteListScreen> {
            NoteListScreen()
        }

        composable<Screens.NoteAddScreen> {
            NoteAddScreen()
        }

        composable<Screens.NoteEditScreen> {
            NoteEditScreen()
        }
    }
}