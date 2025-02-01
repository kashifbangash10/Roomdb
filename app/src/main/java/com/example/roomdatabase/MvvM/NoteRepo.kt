package com.example.roomdatabase.MvvM

import androidx.lifecycle.LiveData
import javax.inject.Inject

class NoteRepo @Inject constructor(private val noteDao: NoteDao) {

    // Function to get all notes
    fun getAllNotes(): LiveData<List<Notes>> {
        return noteDao.getAllNotes() // Note: `getAllNotes` should not be a suspend function
    }

    // Function to insert a note
    suspend fun insertNotes(notes: Notes) {
        noteDao.insert(notes) // Use the DAO instance
    }

    // Function to delete a note by ID
    suspend fun deleteNotes(id: Int) {
        noteDao.deleteNoteById(id) // Updated to use Long to match DAO
    }

    // Update functionality
    suspend fun updateNotes(notes: Notes) {
        noteDao.updateNote(notes)
    }
}
