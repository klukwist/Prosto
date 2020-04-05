package plus.yeti.prostoadapter.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import plus.yeti.prostoadapter.model.Person

class MainViewModel : ViewModel() {
    val persons = MutableLiveData<List<Person>>()

    init {
        loadPersons()
    }

    private fun loadPersons() {
        val result: List<Person> = getFakePersonList()
        persons.postValue(result)
    }

    private fun getFakePersonList(): List<Person> = listOf(Person(
            firstName = "Eddart",
            lastName = "Stark",
            email = "eddart@site.com",
            hasDog = false
        ), Person(
            firstName = "Robert",
            lastName = "Baratheon",
            email = "baratheon@site.com",
            hasDog = false
        ), Person(
            firstName = "Jaime",
            lastName = "Lannister",
            email = "jaime.lannister@site.com",
            hasDog = true
        ), Person(firstName = "Cersei", lastName = "Lannister", email = "1@site.com", hasDog = false), Person(
            firstName = "Daenerys",
            lastName = "Targaryen",
            email = "daene@site.com",
            hasDog = false
        ), Person(
            firstName = "Jorah",
            lastName = "Mormont",
            email = "mormont@site.com",
            hasDog = true
        ), Person(
            firstName = "Sandor",
            lastName = "Clegane",
            email = "clegane@site.com",
            hasDog = true
        ))
}
