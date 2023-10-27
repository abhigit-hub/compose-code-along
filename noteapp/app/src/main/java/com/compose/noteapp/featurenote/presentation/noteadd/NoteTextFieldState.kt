package com.compose.noteapp.featurenote.presentation.noteadd

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true,
)
