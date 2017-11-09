package android.erick.presentation.mapper

import android.erick.domain.model.Name
import android.erick.presentation.model.NameView
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class NameMapper @Inject constructor(): Mapper<NameView, Name> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: Name): NameView {
        return NameView(type.title, type.first, type.last)
    }


}