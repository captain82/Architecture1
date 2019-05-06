package com.captain.ak.architecture1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.zip.Inflater

class NoteAdapter():RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notes:List<Note> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {

        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.note_item, p0, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return notes.size


    }

    fun setNodes(notes:List<Note>)
    {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: NoteViewHolder, p1: Int) {

        val currentNode = notes[p1]
        p0.textViewTitle.text = currentNode.title
        p0.textViewDescription.text = currentNode.description
    }


    class NoteViewHolder(itemView :View): RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)
        var textViewDescription: TextView = itemView.findViewById(R.id.text_view_description)


    }
}