package android.erick.remote.mapper

import android.erick.data.model.NameEntity
import android.erick.data.model.UserEntity
import android.erick.remote.model.NameModel
import android.erick.remote.model.UserModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/7/17.
 */

open class NameEntityMapper @Inject constructor(): EntityMapper<NameModel, NameEntity> {

    override fun mapFromRemote(type: NameModel): NameEntity {
        return NameEntity(type.title, type.first, type.last)
    }

}