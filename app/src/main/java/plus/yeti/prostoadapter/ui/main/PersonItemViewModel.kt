package plus.yeti.prostoadapter.ui.main

import plus.yeti.prostoadapter.base.ProstoViewModel
import plus.yeti.prostoadapter.model.Person

class PersonItemViewModel : ProstoViewModel<Person>() {
    override var data: List<Person> = emptyList()

    fun getName(position: Int) = data[position].lastName + ", " + data[position].firstName

    fun getEmail(position: Int) = data[position].email

    fun hasDog(position: Int): Boolean = data[position].hasDog
}