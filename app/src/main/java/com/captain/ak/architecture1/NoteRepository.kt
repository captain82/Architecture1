package com.captain.ak.architecture1

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class NoteRepository(application:Application) {

    private var noteDao:NoteDao

    private var allNotes:LiveData<List<Note>>



    init {
            val database:NoteDatabase = NoteDatabase.getInstance(application.applicationContext)!!
        noteDao = database.noteDao()

        allNotes = noteDao.getAllNotes()
    }

    fun insert(note:Note)
    {
        val insertNoteAsyncTask = InsertNoteAsync(noteDao).execute(note)
    }

    fun deleteAllNotes(){
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(noteDao).execute()
    }

    fun getAllNotes():LiveData<List<Note>>
    {
        return allNotes
    }

    class DeleteAllNotesAsyncTask(val noteDao: NoteDao): AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit?) {

            noteDao.deleteAll()
        }


    }

    class InsertNoteAsync(noteDao: NoteDao):AsyncTask<Note,Unit,Unit>() {

        val noteDao = noteDao

        override fun doInBackground(vararg p0: Note?) {

            noteDao.insert(p0[0]!!)

        }

    }
}