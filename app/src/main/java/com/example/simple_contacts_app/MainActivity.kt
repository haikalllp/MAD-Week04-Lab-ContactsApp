package com.example.simple_contacts_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ensure status bar icons are dark
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        // Create a RecyclerView with edge-to-edge support
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val people = listOf(
            Person("Alice", "987654321"),
            Person("John", "123456789"),
            Person("Bob", "555123456")
        )

        // Use GridLayoutManager with 2 columns instead of LinearLayoutManager
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = PersonAdapter(people, this)
    }
}
