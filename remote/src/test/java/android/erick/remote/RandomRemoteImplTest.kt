package android.erick.remote

import android.erick.data.model.UserEntity
import android.erick.remote.mapper.UserEntityMapper
import android.erick.remote.model.BaseResponse
import android.erick.remote.model.UserModel
import android.erick.remote.test.factory.UserFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by ericktijero on 11/8/17.
 */
@RunWith(JUnit4::class)
class RandomRemoteImplTest {

    private lateinit var entityMapper: UserEntityMapper
    private lateinit var randomService: RandomService

    private lateinit var randomRemoteImpl: RandomRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        randomService = mock()
        randomRemoteImpl = RandomRemoteImpl(randomService, entityMapper)
    }

    @Test
    fun getBufferoosCompletes() {
        stubBufferooServiceGetBufferoos(Single.just(UserFactory.makeBaseResponse()))
        val testObserver = randomRemoteImpl.getUsers().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBufferoosReturnsData() {
        val userResponse = UserFactory.makeBaseResponse()
        stubBufferooServiceGetBufferoos(Single.just(userResponse))
        val userEntities = mutableListOf<UserEntity>()
        userResponse.result!!.forEach {
            userEntities.add(entityMapper.mapFromRemote(it))
        }

        val testObserver = randomRemoteImpl.getUsers().test()
        testObserver.assertValue(userEntities)
    }

    private fun stubBufferooServiceGetBufferoos(single: Single<BaseResponse<List<UserModel>>>) {
        whenever(randomService.getUsers())
                .thenReturn(single)
    }
}