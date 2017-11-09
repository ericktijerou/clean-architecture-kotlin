package android.erick.presentation

/**
 * Created by ericktijero on 11/8/17.
 */
interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}