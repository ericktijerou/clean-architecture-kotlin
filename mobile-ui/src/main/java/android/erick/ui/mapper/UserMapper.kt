package android.erick.ui.mapper

import android.erick.presentation.model.PictureView
import android.erick.presentation.model.UserView
import android.erick.ui.model.PictureViewModel
import android.erick.ui.model.UserViewModel
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
open class UserMapper @Inject
    constructor(val nameMapper: NameMapper,
                val pictureMapper: PictureMapper):
        Mapper<UserViewModel, UserView> {

    /**
     * Map a [BufferooView] instance to a [BufferooViewModel] instance
     */
    override fun mapToViewModel(type: UserView): UserViewModel {
        return UserViewModel(nameMapper.mapToViewModel(type.name), type.email, pictureMapper.mapToViewModel(type.picture))
    }

}