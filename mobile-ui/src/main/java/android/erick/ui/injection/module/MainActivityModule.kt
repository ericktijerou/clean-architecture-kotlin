package android.erick.ui.injection.module

import android.erick.domain.interactor.main.GetUsers
import android.erick.presentation.main.MainUsersContract
import android.erick.presentation.main.MainUsersPresenter
import android.erick.presentation.mapper.UserMapper
import android.erick.ui.injection.scopes.PerActivity
import android.erick.ui.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by ericktijero on 11/9/17.
 */
@Module
open class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(mainActivity: MainActivity): MainUsersContract.View {
        return mainActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: MainUsersContract.View,
                                        getBufferoos: GetUsers, mapper: UserMapper):
            MainUsersContract.Presenter {
        return MainUsersPresenter(mainView, getBufferoos, mapper)
    }

}
