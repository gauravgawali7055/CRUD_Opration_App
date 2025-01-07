package com.example.crud_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_app.databinding.ActivityAddNoteBinding
import com.example.crud_app.databinding.ActivityMainBinding

class Add_Note_Activity : AppCompatActivity() {
//    lateinit allows you to declare a non-null variable without initializing it at the time of declaration.
//    ActivityAddNoteBinding is a generated binding class. It is created automatically when you enable View Binding in your project and corresponds to the activity_add_note.xml layout file.
//This binding class provides direct references to the views defined in the XML layout, eliminating the need for findViewById().
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db=NoteDatabaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val note = Note(0,title, content)
            db.insertNote(note)
            finish() //it will close this activity and automaticlly go to the main activity
            Toast.makeText(this,"Note saved !", Toast.LENGTH_SHORT).show()

        }
    }
}