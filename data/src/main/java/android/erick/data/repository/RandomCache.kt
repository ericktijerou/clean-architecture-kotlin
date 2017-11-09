package android.erick.data.repository

import android.erick.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ericktijero on 11/8/17.
 */
interface RandomCache {

    /**
     * Clear all Bufferoos from the cache
     */
    fun clearUsers(): Completable

    /**
     * Save a given list of Bufferoos to the cache
     */
    fun saveUsers(users: List<UserEntity>): Completable

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getUsers(): Single<List<UserEntity>>

    /**
     * Checks if an element (User) exists in the cache.

     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * Checks if an element (User) exists in the cache.

     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Checks if the cache is expired.

     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean

}