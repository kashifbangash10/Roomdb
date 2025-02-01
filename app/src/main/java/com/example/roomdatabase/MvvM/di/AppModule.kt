package com.example.roomdatabase.MvvM.di

import android.content.Context
import androidx.room.Room
import com.example.roomdatabase.MvvM.NoteDao
import com.example.roomdatabase.MvvM.NotesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class AppModule {


    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): NotesDb {
            return Room.databaseBuilder(
                context,
                NotesDb::class.java,
                "notes_database"
            ).build()
        }

        @Provides
        @Singleton
        fun provideNotesDao(database: NotesDb): NoteDao {
            return database.notesDao()
        }


    }

}