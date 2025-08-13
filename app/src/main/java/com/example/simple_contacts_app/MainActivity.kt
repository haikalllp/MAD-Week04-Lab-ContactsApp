package com.example.simple_contacts_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ensure status bar icons are dark
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        // Load FragmentList and FragmentAdd
        supportFragmentManager.beginTransaction()
            .replace(R.id.list_container, FragmentList())
            .replace(R.id.add_container, FragmentAdd())
            .commit()
    }
}
