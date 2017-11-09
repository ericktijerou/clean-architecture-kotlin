package android.erick.data.source

import android.erick.data.model.UserEntity
import android.erick.data.repository.RandomCache
import android.erick.data.repository.RandomDataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class RandomCacheDataStore @Inject constructor(private val randomCache: RandomCache) :
        RandomDataStore {

    /**
     * Clear all Bufferoos from the cache
     */
    override fun clearUsers(): Completable {
        return randomCache.clearUsers()
    }

    /**
     * Save a given [List] of [BufferooEntity] instances to the cache
     */
    override fun saveUsers(users: List<UserEntity>): Completable {
        return randomCache.saveUsers(users)
                .doOnComplete {
                    randomCache.setLastCacheTime(System.currentTimeMillis())
                }
    }

    /**
     * Retrieve a list of [BufferooEntity] instance from the cache
     */
    override fun getUsers(): Single<List<UserEntity>> {
        return randomCache.getUsers()
    }

}