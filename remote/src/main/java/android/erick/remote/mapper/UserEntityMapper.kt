package android.erick.remote.mapper

import android.erick.data.model.UserEntity
import android.erick.remote.model.UserModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/7/17.
 */

open class UserEntityMapper @Inject
    constructor(private val nameEntityMapper: NameEntityMapper,
                private val pictureEntityMapper: PictureEntityMapper) :
        EntityMapper<UserModel, UserEntity> {

    override fun mapFromRemote(type: UserModel): UserEntity {
        return UserEntity(nameEntityMapper.mapFromRemote(type.name), type.email, pictureEntityMapper.mapFromRemote(type.picture))
    }

}