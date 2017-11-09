package android.erick.presentation.mapper

/**
 * Created by ericktijero on 11/8/17.
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}