package android.erick.data.source

import android.erick.data.model.UserEntity
import android.erick.data.repository.RandomDataStore
import android.erick.data.repository.RandomRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class RandomRemoteDataStore @Inject constructor(private val randomRemote: RandomRemote) :
        RandomDataStore {

    override fun clearUsers(): Completable {
        throw UnsupportedOperationException()
    }

    override fun saveUsers(users: List<UserEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getUsers(): Single<List<UserEntity>> {
        return randomRemote.getUsers()
    }

}