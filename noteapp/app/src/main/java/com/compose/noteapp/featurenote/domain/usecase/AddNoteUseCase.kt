package com.compose.noteapp.featurenote.domain.usecase

import com.compose.noteapp.featurenote.domain.model.InvalidNoteException
import com.compose.noteapp.featurenote.domain.model.Note
import com.compose.noteapp.featurenote.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("The title of the note can't be empty")

        if (note.content.isBlank())
            throw InvalidNoteException("The content of the note can't be empty")

        repository.insertNote(note)
    }
}