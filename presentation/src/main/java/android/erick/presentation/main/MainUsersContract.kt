package android.erick.presentation.main

import android.erick.presentation.BasePresenter
import android.erick.presentation.BaseView
import android.erick.presentation.model.UserView

/**
 * Created by ericktijero on 11/8/17.
 */
interface MainUsersContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showUsers(users: List<UserView>)

        fun hideUsers()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveUsers()

    }

}