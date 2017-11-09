package android.erick.data.repository

import android.erick.data.model.UserEntity
import io.reactivex.Single

/**
 * Created by ericktijero on 11/8/17.
 */
interface RandomRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getUsers(): Single<List<UserEntity>>

}