package de.ries.notesapp.di

import android.content.Context
import androidx.room.Room
import de.ries.notesapp.data.local.NoteDao
import de.ries.notesapp.data.local.NoteDatabase
import de.ries.notesapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context, NoteDatabase::class.java,
            Constants.NOTE_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()

}

