package android.erick.presentation.mapper

import android.erick.domain.model.Name
import android.erick.domain.model.Picture
import android.erick.presentation.model.NameView
import android.erick.presentation.model.PictureView
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class PictureMapper @Inject constructor(): Mapper<PictureView, Picture> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: Picture): PictureView {
        return PictureView(type.large, type.medium, type.thumbnail)
    }


}