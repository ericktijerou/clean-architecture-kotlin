package android.erick.data

import android.erick.data.mapper.UserMapper
import android.erick.data.model.UserEntity
import android.erick.data.source.RandomDataStoreFactory
import android.erick.data.source.RandomRemoteDataStore
import android.erick.domain.model.User
import android.erick.domain.repository.RandomRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
class RandomDataRepository @Inject constructor(private val factory: RandomDataStoreFactory,
                                               private val userMapper: UserMapper) :
        RandomRepository {

    override fun clearUsers(): Completable {
        return factory.retrieveCacheDataStore().clearUsers()
    }

    override fun saveUsers(users: List<User>): Completable {
        val userEntities = users.map { userMapper.mapToEntity(it) }
        return saveUsersEntities(userEntities)
    }

    private fun saveUsersEntities(users: List<UserEntity>): Completable {
        return factory.retrieveCacheDataStore().saveUsers(users)
    }

    override fun getUsers(): Single<List<User>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getUsers()
                .flatMap {
                    if (dataStore is RandomRemoteDataStore) {
                        saveUsersEntities(it).toSingle { it }
                    } else {
                        Single.just(it)
                    }
                }
                .map { list ->
                    list.map { listItem ->
                        userMapper.mapFromEntity(listItem)
                    }
                }
    }

}