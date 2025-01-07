package com.example.crud_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: NoteDatabaseHelper
    private lateinit var notesAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        // Initialize RecyclerView adapter with notes
        notesAdapter = NoteAdapter(db.getAllNotes() ?: emptyList())
        binding.notdRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.notdRecyclerview.adapter = notesAdapter

        // Set OnClickListener for FloatingActionButton
        binding.addButton.setOnClickListener {
            val intent = Intent(this, Add_Note_Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh RecyclerView with updated notes
        notesAdapter.refreshData(db.getAllNotes() ?: emptyList())
    }
}
