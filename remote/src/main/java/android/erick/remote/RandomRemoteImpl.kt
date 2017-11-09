package android.erick.remote

import android.erick.data.model.UserEntity
import android.erick.data.repository.RandomRemote
import android.erick.remote.mapper.UserEntityMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by ericktijero on 11/7/17.
 */
class RandomRemoteImpl @Inject constructor(private val randomService: RandomService,
                                           private val userEntityMapper: UserEntityMapper) :

        RandomRemote {

    override fun getUsers(): Single<List<UserEntity>> {
        return randomService.getUsers()
                .map {
                    it.results!!.map { listItem ->
                        userEntityMapper.mapFromRemote(listItem)
                    }
                }
    }
}