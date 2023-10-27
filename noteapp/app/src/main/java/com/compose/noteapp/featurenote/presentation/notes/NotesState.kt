package com.compose.noteapp.featurenote.presentation.notes

import com.compose.noteapp.featurenote.domain.model.Note
import com.compose.noteapp.featurenote.domain.util.NoteOrder
import com.compose.noteapp.featurenote.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
