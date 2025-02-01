package com.example.roomdatabase.MvvM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepo
) : ViewModel() {

    // Function to get all notes
    fun getAllNotes(): LiveData<List<Notes>> {
        return repository.getAllNotes()
    }

    // Function to add notes
    fun addNotes(note: Notes) {
        viewModelScope.launch {
            repository.insertNotes(note)
        }
    }

    // Function to update a note
    fun updateNote(note: Notes) {
        viewModelScope.launch {
            repository.updateNotes(note)
        }
    }

    // Function to delete a note by ID
    fun deleteNotesById(id: Int) {
        viewModelScope.launch {
            repository.deleteNotes(id)
        }
    }
}
