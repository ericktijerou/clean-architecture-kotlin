package android.erick.ui.injection

import android.app.Application
import android.erick.ui.RandomApplication
import android.erick.ui.injection.module.ActivityBindingModule
import android.erick.ui.injection.module.ApplicationModule
import android.erick.ui.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by ericktijero on 11/9/17.
 */
@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: RandomApplication)

}
