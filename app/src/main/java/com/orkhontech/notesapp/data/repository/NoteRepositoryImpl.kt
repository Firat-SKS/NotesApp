package com.orkhontech.notesapp.data.repository

import com.orkhontech.notesapp.data.data_source.NoteDao
import com.orkhontech.notesapp.domain.model.Note
import com.orkhontech.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao:NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }

    override suspend fun updateNote(note: Note) {
        return dao.updateNote(note)
    }
}