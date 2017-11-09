package android.erick.cache.mapper

import android.erick.cache.model.CachedName
import android.erick.cache.model.CachedPicture
import android.erick.data.model.NameEntity
import android.erick.data.model.PictureEntity
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class PictureEntityMapper @Inject constructor(): EntityMapper<CachedPicture, PictureEntity> {

    /**
     * Map a [BufferooEntity] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: PictureEntity): CachedPicture {
        return CachedPicture(type.large, type.medium, type.thumbnail)
    }

    /**
     * Map a [CachedBufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapFromCached(type: CachedPicture): PictureEntity {
        return PictureEntity(type.large, type.medium, type.thumbnail)
    }

}