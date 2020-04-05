package plus.yeti.prostoadapter.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.*
import plus.yeti.prostoadapter.R
import plus.yeti.prostoadapter.base.ProstoAdapter
import plus.yeti.prostoadapter.base.ProstoViewModel
import plus.yeti.prostoadapter.databinding.ItemPersonBinding
import plus.yeti.prostoadapter.model.Person

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val adapter =
        object : ProstoAdapter<ItemPersonBinding, Person>() {
            override val viewModel = PersonItemViewModel()
            override val layoutId = R.layout.item_person
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainRecyclerView.adapter = adapter
        viewModel.persons.observe(viewLifecycleOwner, Observer {
            adapter.setData(it ?: emptyList())
        })
    }

}
