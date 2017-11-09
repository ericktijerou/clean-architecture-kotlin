package android.erick.data.repository

import android.erick.data.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ericktijero on 11/8/17.
 */
interface RandomDataStore {

    fun clearUsers(): Completable

    fun saveUsers(users: List<UserEntity>): Completable

    fun getUsers(): Single<List<UserEntity>>

}