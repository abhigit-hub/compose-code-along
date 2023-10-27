package com.compose.noteapp.featurenote.presentation.notes

import com.compose.noteapp.featurenote.domain.model.Note
import com.compose.noteapp.featurenote.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
