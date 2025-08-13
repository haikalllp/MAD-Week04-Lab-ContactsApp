package com.example.simple_contacts_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Adapter for displaying a list of Person objects in a RecyclerView
class PersonAdapter(
    private val people: List<Person>, // List of people to display
    private val context: Context      // Context for Toast messages
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    // ViewHolder class holds references to the views for each row
    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.textName)   // Name TextView
        val textPhone: TextView = view.findViewById(R.id.textPhone) // Phone TextView
        val btnCall: Button = view.findViewById(R.id.btnCall)       // Call Button
    }

    // Inflates the item layout and creates a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    // Binds data to the views in each row
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.textName.text = person.name
        holder.textPhone.text = person.phone

        // Set click listener for the entire row
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                "Selected ${person.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Set click listener for the Call button
        holder.btnCall.setOnClickListener {
            Toast.makeText(
                context,
                "Calling ${person.name} (${person.phone})",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // Returns the total number of items
    override fun getItemCount(): Int = people.size
}