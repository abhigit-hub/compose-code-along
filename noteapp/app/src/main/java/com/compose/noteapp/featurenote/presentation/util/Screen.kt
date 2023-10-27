package com.compose.noteapp.featurenote.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddNotesScreen: Screen("add_notes_screen")
}