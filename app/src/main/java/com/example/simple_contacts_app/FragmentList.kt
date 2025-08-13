package com.example.simple_contacts_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // Sample data for the RecyclerView
        val people = listOf(
            Person("Alice", "987654321"),
            Person("John", "123456789"),
            Person("Bob", "555123456")
        )

        // Set up the RecyclerView with a GridLayoutManager and an adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = PersonAdapter(people, requireContext())
    }
}