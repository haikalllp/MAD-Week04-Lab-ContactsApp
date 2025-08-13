package com.example.simple_contacts_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simple_contacts_app.Person

class PeopleViewModel : ViewModel() {
    private val _people = MutableLiveData<List<Person>>(emptyList())
    val people: LiveData<List<Person>> = _people

    fun add(person: Person) {
        _people.value = _people.value.orEmpty() + person
    }
}
