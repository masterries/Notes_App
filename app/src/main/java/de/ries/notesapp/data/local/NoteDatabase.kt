package de.ries.notesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import de.ries.notesapp.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}