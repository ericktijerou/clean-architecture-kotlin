package android.erick.domain.repository

import android.erick.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by ericktijero on 11/8/17.
 */
interface RandomRepository {

    fun clearUsers(): Completable

    fun saveUsers(users: List<User>): Completable

    fun getUsers(): Single<List<User>>

}