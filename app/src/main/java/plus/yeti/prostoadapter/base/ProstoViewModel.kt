package plus.yeti.prostoadapter.base

import androidx.lifecycle.ViewModel

/**
 * Created by Alex Che on 29.03.2020.
 * http://yeti.plus, https://github.com/klukwist/
 */

abstract class ProstoViewModel<T>: ViewModel() {
    abstract var data: List<T>
}