package android.erick.remote.mapper

import android.erick.data.model.PictureEntity
import android.erick.remote.model.PictureModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/7/17.
 */
open class PictureEntityMapper @Inject constructor(): EntityMapper<PictureModel, PictureEntity> {
    override fun mapFromRemote(type: PictureModel): PictureEntity {
        return PictureEntity(type.large, type.medium, type.thumbnail)
    }
}