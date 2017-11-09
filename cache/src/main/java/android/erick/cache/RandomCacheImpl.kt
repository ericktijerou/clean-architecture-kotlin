package android.erick.cache

import android.database.sqlite.SQLiteDatabase
import android.erick.cache.db.Db
import android.erick.cache.db.DbOpenHelper
import android.erick.cache.db.constants.RandomConstants
import android.erick.cache.db.mapper.UserMapper
import android.erick.cache.mapper.UserEntityMapper
import android.erick.cache.model.CachedUser
import android.erick.data.model.UserEntity
import android.erick.data.repository.RandomCache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class RandomCacheImpl @Inject constructor(dbOpenHelper: DbOpenHelper,
                                            private val entityMapper: UserEntityMapper,
                                            private val mapper: UserMapper,
                                            private val preferencesHelper: PreferencesHelper):
        RandomCache {

    private val EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    private var database: SQLiteDatabase = dbOpenHelper.writableDatabase

    /**
     * Retrieve an instance from the database, used for tests
     */
    internal fun getDatabase(): SQLiteDatabase {
        return database
    }

    /**
     * Remove all the data from all the tables in the database.
     */
    override fun clearUsers(): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                database.delete(Db.UsersTable.TABLE_NAME, null, null)
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    /**
     * Save the given list of [BufferooEntity] instances to the database.
     */
    override fun saveUsers(users: List<UserEntity>): Completable {
        return Completable.defer {
            database.beginTransaction()
            try {
                users.forEach {
                    saveUser(entityMapper.mapToCached(it))
                }
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
            Completable.complete()
        }
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the database.
     */
    override fun getUsers(): Single<List<UserEntity>> {
        return Single.defer<List<UserEntity>> {
            val updatesCursor = database.rawQuery(RandomConstants.QUERY_GET_ALL_BUFFEROOS, null)
            val users = mutableListOf<UserEntity>()

            while (updatesCursor.moveToNext()) {
                val cachedBufferoo = mapper.parseCursor(updatesCursor)
                users.add(entityMapper.mapFromCached(cachedBufferoo))
            }

            updatesCursor.close()
            Single.just<List<UserEntity>>(users)
        }
    }

    /**
     * Helper method for saving a [CachedBufferoo] instance to the database.
     */
    private fun saveUser(cachedUser: CachedUser) {
        database.insert(Db.UsersTable.TABLE_NAME, null, mapper.toContentValues(cachedUser))
    }

    /**
     * Checked whether there are instances of [CachedBufferoo] stored in the cache
     */
    override fun isCached(): Boolean {
        return database.rawQuery(RandomConstants.QUERY_GET_ALL_BUFFEROOS, null).count > 0
    }

    /**
     * Set a point in time at when the cache was last updated
     */
    override fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    /**
     * Check whether the current cached data exceeds the defined [EXPIRATION_TIME] time
     */
    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

}