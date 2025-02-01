package com.example.roomdatabase.MvvM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDb : RoomDatabase() {

    abstract fun notesDao(): NoteDao


}
