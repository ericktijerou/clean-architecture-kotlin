package android.erick.remote

import android.erick.remote.model.BaseResponse
import android.erick.remote.model.UserModel
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by ericktijero on 11/7/17.
 */
interface RandomService {
    @GET("api/?results=50")
    fun getUsers(): Single<BaseResponse<List<UserModel>>>
}