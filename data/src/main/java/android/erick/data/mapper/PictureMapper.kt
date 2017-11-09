package android.erick.data.mapper

import android.erick.data.model.PictureEntity
import android.erick.domain.model.Picture
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class PictureMapper @Inject constructor(): Mapper<PictureEntity, Picture> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: PictureEntity): Picture {
        return Picture(type.large, type.medium, type.thumbnail)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Picture): PictureEntity {
        return PictureEntity(type.large, type.medium, type.thumbnail)
    }


}