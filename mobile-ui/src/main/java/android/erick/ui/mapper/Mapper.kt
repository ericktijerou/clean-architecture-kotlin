package android.erick.ui.mapper

/**
 * Created by ericktijero on 11/9/17.
 */
interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}