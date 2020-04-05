package plus.yeti.prostoadapter.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Alex Che on 29.03.2020.
 * http://yeti.plus, https://github.com/klukwist/
 */

abstract class ProstoAdapter<TBinding : ViewDataBinding, TData> : RecyclerView.Adapter<ProstoHolder<TBinding>>() {

    abstract val viewModel: ProstoViewModel<TData>
    abstract val layoutId: Int

    private var dataSize: Int = 0

    open fun setData(data: List<TData>) {
        this.dataSize = data.size
        viewModel.data = data
        notifyDataSetChanged()
    }

    open var onBind: ((ProstoHolder<TBinding>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProstoHolder<TBinding> =
        ProstoHolder.create(parent, layoutId)

    override fun getItemCount(): Int = dataSize

    override fun onBindViewHolder(holder: ProstoHolder<TBinding>, position: Int) {
        holder.bind(viewModel, position)
        onBind?.invoke(holder)
    }
}