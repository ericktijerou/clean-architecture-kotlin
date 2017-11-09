package android.erick.remote.mapper

import android.erick.remote.test.factory.UserFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

/**
 * Created by ericktijero on 11/8/17.
 */
@RunWith(JUnit4::class)
class UserEntityMapperTest {

    private lateinit var userEntityMapper: UserEntityMapper
    private lateinit var nameEntityMapper: NameEntityMapper
    private lateinit var pictureEntityMapper: PictureEntityMapper

    @Before
    fun setUp() {
        nameEntityMapper = NameEntityMapper()
        pictureEntityMapper = PictureEntityMapper()
        userEntityMapper = UserEntityMapper(nameEntityMapper, pictureEntityMapper)
    }

    @Test
    fun mapFromRemoteMapsData() {
        val userModel = UserFactory.makeUserModel()
        val userEntity = userEntityMapper.mapFromRemote(userModel)

        assertEquals(userModel.name.first, userEntity.name.first)
        assertEquals(userModel.email, userEntity.email)
        assertEquals(userModel.picture.medium, userEntity.picture.medium)
    }

}