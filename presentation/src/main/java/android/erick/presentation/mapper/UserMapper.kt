package android.erick.presentation.mapper

import android.erick.domain.model.Picture
import android.erick.domain.model.User
import android.erick.presentation.model.PictureView
import android.erick.presentation.model.UserView
import javax.inject.Inject

/**
 * Created by ericktijero on 11/8/17.
 */
open class UserMapper @Inject
    constructor(private val nameMapper: NameMapper,
                private val pictureMapper: PictureMapper):
        Mapper<UserView, User> {

    /**
     * Map a [Bufferoo] instance to a [BufferooView] instance
     */
    override fun mapToView(type: User): UserView {
        return UserView(nameMapper.mapToView(type.name), type.email, pictureMapper.mapToView(type.picture))
    }

}