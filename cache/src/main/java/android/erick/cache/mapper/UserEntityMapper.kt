package android.erick.cache.mapper

import android.erick.cache.model.CachedPicture
import android.erick.cache.model.CachedUser
import android.erick.data.model.PictureEntity
import android.erick.data.model.UserEntity
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class UserEntityMapper @Inject
        constructor(val nameEntityMapper: NameEntityMapper,
                    val pictureEntityMapper: PictureEntityMapper):
        EntityMapper<CachedUser, UserEntity> {

    /**
     * Map a [BufferooEntity] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: UserEntity): CachedUser {
        return CachedUser(nameEntityMapper.mapToCached(type.name), type.email, pictureEntityMapper.mapToCached(type.picture))
    }

    /**
     * Map a [CachedBufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapFromCached(type: CachedUser): UserEntity {
        return UserEntity(nameEntityMapper.mapFromCached(type.name), type.email, pictureEntityMapper.mapFromCached(type.picture))
    }

}