package com.captain.ak.architecture1

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

public class NoteViewModel(application: Application): AndroidViewModel(application) {

    private var repository:NoteRepository = NoteRepository(application)

    private var allNotes:LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note:Note)
    {
        repository.insert(note)
    }

    fun deleteAllNodes()
    {
        repository.deleteAllNotes()
    }

    fun getAllNodes():LiveData<List<Note>>
    {
        return allNotes
    }
}