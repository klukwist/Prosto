package plus.yeti.prostoadapter.util

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visible")
fun View.visible(isVisible: Boolean){
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}