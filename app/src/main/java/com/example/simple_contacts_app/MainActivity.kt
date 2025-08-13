package com.example.simple_contacts_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val people = listOf(
            Person("Alice", "987654321"),
            Person("John", "123456789"),
            Person("Bob", "555123456")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonAdapter(people, this)
    }
}
