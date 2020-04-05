package plus.yeti.prostoadapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import plus.yeti.prostoadapter.BR

/**
 * Created by Alex Che on 29.03.2020.
 * http://yeti.plus, https://github.com/klukwist/
 */

open class ProstoHolder<TBinding : ViewDataBinding>(val binding: TBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun <TData, TViewModel : ProstoViewModel<TData>> bind(viewModel: TViewModel, position: Int) {
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.position, position)
        binding.executePendingBindings()
    }

    companion object {
        fun <TBinding : ViewDataBinding> create(parent: ViewGroup, layoutId: Int): ProstoHolder<TBinding> {
            val inflater = LayoutInflater.from(parent.context)
            val binding: TBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false)
            return ProstoHolder(binding)
        }
    }
}