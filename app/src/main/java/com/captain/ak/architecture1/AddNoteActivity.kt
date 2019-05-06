package com.captain.ak.architecture1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TITLE = "extraTitle"
        const val EXTRA_DESCRIPTION = "extraDescription"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.abc_ic_arrow_drop_right_black_24dp)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.add_note_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId)
        {
            R.id.save_note->{
                saveNote()
                true
            }
            else ->
            {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun saveNote()
    {
        if (edit_text_title.text.toString().trim().isBlank() || edit_text_description.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, edit_text_title.text.toString())
            putExtra(EXTRA_DESCRIPTION, edit_text_description.text.toString())
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
