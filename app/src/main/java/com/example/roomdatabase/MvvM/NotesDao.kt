package com.example.roomdatabase.MvvM

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    // Insert a new note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Notes)

    // Fetch all notes
    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

    // Fetch a single note by its ID
    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Long): Notes?

    // Delete a specific note by its ID
    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNoteById(id: Int)

    // Optional: Delete all notes (useful for debugging or resetting the databas

    @Update
   suspend fun updateNote(note: Notes )

}
