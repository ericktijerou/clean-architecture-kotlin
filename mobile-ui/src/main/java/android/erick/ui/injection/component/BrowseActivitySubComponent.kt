package android.erick.ui.injection.component

import android.erick.ui.main.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by ericktijero on 11/9/17.
 */
@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}