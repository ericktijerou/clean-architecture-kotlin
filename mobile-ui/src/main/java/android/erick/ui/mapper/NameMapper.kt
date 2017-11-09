package android.erick.ui.mapper

import android.erick.presentation.model.NameView
import android.erick.presentation.model.PictureView
import android.erick.ui.model.NameViewModel
import android.erick.ui.model.PictureViewModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
open class NameMapper @Inject constructor(): Mapper<NameViewModel, NameView> {

    /**
     * Map a [BufferooView] instance to a [BufferooViewModel] instance
     */
    override fun mapToViewModel(type: NameView): NameViewModel {
        return NameViewModel(type.title, type.first, type.last)
    }

}