package com.compose.noteapp.di

import android.app.Application
import androidx.room.Room
import com.compose.noteapp.featurenote.data.datasource.NoteDatabase
import com.compose.noteapp.featurenote.data.repository.NoteRepositoryImpl
import com.compose.noteapp.featurenote.domain.repository.NoteRepository
import com.compose.noteapp.featurenote.domain.usecase.AddNoteUseCase
import com.compose.noteapp.featurenote.domain.usecase.DeleteNoteUseCase
import com.compose.noteapp.featurenote.domain.usecase.GetNoteUseCase
import com.compose.noteapp.featurenote.domain.usecase.GetNotesUseCase
import com.compose.noteapp.featurenote.domain.usecase.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository)
        )
    }
}