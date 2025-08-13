package com.example.simple_contacts_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import kotlin.getValue

class AddFragment : Fragment() {
    private val vm: PeopleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val etName = view.findViewById<EditText>(R.id.etName)
        val etPhone = view.findViewById<EditText>(R.id.etPhone)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            if (name.isNotBlank() && phone.isNotBlank()) {
                vm.add(Person(name, phone))
                etName.text.clear()
                etPhone.text.clear()
                etName.requestFocus()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter both name and phone number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}