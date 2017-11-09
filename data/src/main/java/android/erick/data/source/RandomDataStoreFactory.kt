package android.erick.data.source

import android.erick.data.repository.RandomCache
import android.erick.data.repository.RandomDataStore
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class RandomDataStoreFactory @Inject constructor(
        private val randomCache: RandomCache,
        private val randomCacheDataStore: RandomCacheDataStore,
        private val randomRemoteDataStore: RandomRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): RandomDataStore {
        if (randomCache.isCached() && !randomCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveCacheDataStore(): RandomDataStore {
        return randomCacheDataStore
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): RandomDataStore {
        return randomRemoteDataStore
    }

}