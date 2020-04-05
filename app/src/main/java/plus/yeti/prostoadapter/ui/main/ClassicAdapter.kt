package plus.yeti.prostoadapter.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import plus.yeti.prostoadapter.BR
import plus.yeti.prostoadapter.R
import plus.yeti.prostoadapter.databinding.ItemPersonBinding
import plus.yeti.prostoadapter.model.Person

@Deprecated("use ProstoAdapter()", ReplaceWith("object: ProstoAdapter<BindingType, DataType>{}"))
class ClassicAdapter : RecyclerView.Adapter<ClassicHolder>() {

    private val viewModel = PersonItemViewModel()

    private val data: List<Person>
        get() = viewModel.data

    fun setData(persons: List<Person>) {
        viewModel.data = persons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassicHolder =
        ClassicHolder.create(parent)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ClassicHolder, position: Int) {
        holder.bind(viewModel, position)
    }
}

class ClassicHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(viewModel: PersonItemViewModel, position: Int) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.position, position)
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): ClassicHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding: ItemPersonBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_person, parent, false)
            return ClassicHolder(binding)
        }
    }
}


