package android.erick.data.mapper

import android.erick.data.model.UserEntity
import android.erick.domain.model.User
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class UserMapper @Inject
    constructor(private val nameMapper: NameMapper,
                private val pictureMapper: PictureMapper):
        Mapper<UserEntity, User> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: UserEntity): User {
        return User(nameMapper.mapFromEntity(type.name), type.email, pictureMapper.mapFromEntity(type.picture))
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(nameMapper.mapToEntity(type.name), type.email, pictureMapper.mapToEntity(type.picture))
    }


}