package android.erick.presentation.main

import android.erick.domain.interactor.SingleUseCase
import android.erick.domain.model.User
import android.erick.presentation.mapper.UserMapper
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
class MainUsersPresenter @Inject constructor(val mainView: MainUsersContract.View,
                                             val getUsersUseCase: SingleUseCase<List<User>, Void>,
                                             val userMapper: UserMapper):
        MainUsersContract.Presenter {

    init {
        mainView.setPresenter(this)
    }

    override fun start() {
        retrieveUsers()
    }

    override fun stop() {
        getUsersUseCase.dispose()
    }

    override fun retrieveUsers() {
        getUsersUseCase.execute(UserSubscriber())
    }

    internal fun handleGetBufferoosSuccess(users: List<User>) {
        mainView.hideErrorState()
        if (users.isNotEmpty()) {
            mainView.hideEmptyState()
            mainView.showUsers(users.map { userMapper.mapToView(it) })
        } else {
            mainView.hideUsers()
            mainView.showEmptyState()
        }
    }

    inner class UserSubscriber: DisposableSingleObserver<List<User>>() {

        override fun onSuccess(t: List<User>) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
            mainView.hideUsers()
            mainView.hideEmptyState()
            mainView.showErrorState()
        }

    }

}