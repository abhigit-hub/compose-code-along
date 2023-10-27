package com.compose.noteapp.featurenote.domain.usecase

import com.compose.noteapp.featurenote.domain.model.Note
import com.compose.noteapp.featurenote.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}