package android.erick.ui.injection.module

import android.app.Application
import android.content.Context
import android.erick.cache.PreferencesHelper
import android.erick.cache.RandomCacheImpl
import android.erick.cache.db.DbOpenHelper
import android.erick.data.RandomDataRepository
import android.erick.data.executor.JobExecutor
import android.erick.data.mapper.UserMapper
import android.erick.data.repository.RandomCache
import android.erick.data.repository.RandomRemote
import android.erick.data.source.RandomDataStoreFactory
import android.erick.domain.executor.PostExecutionThread
import android.erick.domain.executor.ThreadExecutor
import android.erick.domain.repository.RandomRepository
import android.erick.remote.RandomRemoteImpl
import android.erick.remote.RandomService
import android.erick.remote.RandomServiceFactory
import android.erick.remote.mapper.UserEntityMapper
import android.erick.ui.BuildConfig
import android.erick.ui.UiThread
import android.erick.ui.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides

/**
 * Created by ericktijero on 11/9/17.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: RandomDataStoreFactory,
                                           mapper: UserMapper): RandomRepository {
        return RandomDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: android.erick.cache.mapper.UserEntityMapper,
                                      mapper: android.erick.cache.db.mapper.UserMapper,
                                      helper: PreferencesHelper): RandomCache {
        return RandomCacheImpl(factory, entityMapper, mapper, helper)
    }

    //asdasdasdasdasdasdasdsadasdas problemas :c
    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: RandomService,
                                       factory: UserEntityMapper): RandomRemote {
        return RandomRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): RandomService {
        return RandomServiceFactory.makeRandomService(BuildConfig.DEBUG)
    }
}
