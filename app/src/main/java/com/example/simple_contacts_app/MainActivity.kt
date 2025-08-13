package com.example.simple_contacts_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ensure status bar icons are dark
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        // Load FragmentList and FragmentAdd
        supportFragmentManager.beginTransaction()
            .replace(R.id.list_container, ListFragment())
            .replace(R.id.add_container, AddFragment())
            .commit()
    }
}
