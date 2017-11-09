package android.erick.ui.mapper

import android.erick.presentation.model.PictureView
import android.erick.ui.model.PictureViewModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
open class PictureMapper @Inject constructor(): Mapper<PictureViewModel, PictureView> {

    /**
     * Map a [BufferooView] instance to a [BufferooViewModel] instance
     */
    override fun mapToViewModel(type: PictureView): PictureViewModel {
        return PictureViewModel(type.large, type.medium, type.thumbnail)
    }

}