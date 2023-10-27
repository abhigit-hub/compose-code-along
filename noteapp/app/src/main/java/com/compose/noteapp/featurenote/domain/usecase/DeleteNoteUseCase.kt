package com.compose.noteapp.featurenote.domain.usecase

import com.compose.noteapp.featurenote.domain.model.Note
import com.compose.noteapp.featurenote.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}