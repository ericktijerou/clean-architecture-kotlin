package android.erick.data.mapper

import android.erick.data.model.NameEntity
import android.erick.data.model.PictureEntity
import android.erick.domain.model.Name
import android.erick.domain.model.Picture
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class NameMapper @Inject constructor(): Mapper<NameEntity, Name> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: NameEntity): Name {
        return Name(type.title, type.first, type.last)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Name): NameEntity {
        return NameEntity(type.title, type.first, type.last)
    }


}