package com.orkhontech.notesapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val noteId: Int = 0,
    val noteTitle: String,
    val noteContent: String,
    val noteTimestamp: Long,
    val noteBackgroundColor: String
)
