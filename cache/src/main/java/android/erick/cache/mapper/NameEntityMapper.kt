package android.erick.cache.mapper

import android.erick.cache.model.CachedName
import android.erick.data.model.NameEntity
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class NameEntityMapper @Inject constructor(): EntityMapper<CachedName, NameEntity> {

    /**
     * Map a [BufferooEntity] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: NameEntity): CachedName {
        return CachedName(type.first, type.title, type.last)
    }

    /**
     * Map a [CachedBufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapFromCached(type: CachedName): NameEntity {
        return NameEntity(type.first, type.title, type.last)
    }

}