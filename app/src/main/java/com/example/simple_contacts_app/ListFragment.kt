package com.example.simple_contacts_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private val vm: PeopleViewModel by activityViewModels()
    private lateinit var adapter: PersonAdapter

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

        // Initialize the adapter with an empty list
        adapter = PersonAdapter(emptyList(), requireContext())

        // Set up the RecyclerView with a GridLayoutManager and an adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        vm.people.observe(viewLifecycleOwner) { list ->
            adapter.updateData(list)
        }
    }
}