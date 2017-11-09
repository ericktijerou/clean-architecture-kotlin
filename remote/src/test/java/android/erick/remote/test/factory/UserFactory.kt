package android.erick.remote.test.factory

import android.erick.remote.model.*
import android.erick.remote.test.factory.DataFactory.Factory.randomInt
import android.erick.remote.test.factory.DataFactory.Factory.randomUuid
import com.sun.xml.internal.rngom.parse.host.Base

/**
 * Created by ericktijero on 11/8/17.
 */
class UserFactory {
    companion object Factory {

        fun makeUserModelList(count: Int): List<UserModel> {
            val bufferooRepository = mutableListOf<UserModel>()
            repeat(count) {
                bufferooRepository.add(makeUserModel())
            }
            return bufferooRepository
        }

        fun makeBaseResponse(): BaseResponse<List<UserModel>> {
            val baseResponse = BaseResponse<List<UserModel>>()
            baseResponse.result = makeUserModelList(5)
            baseResponse.info = makeInfoResponse()
            return baseResponse
        }

        fun makeNameResponse(): NameModel {
            return NameModel(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeInfoResponse(): InfoResponse {
            return InfoResponse(randomUuid(), randomInt(), randomInt(), randomUuid())
        }

        fun makePictureResponse(): PictureModel {
            return PictureModel(randomUuid(), randomUuid(), randomUuid())
        }

        fun makeUserModel(): UserModel {
            return UserModel(makeNameResponse(), randomUuid(), makePictureResponse())
        }

    }
}