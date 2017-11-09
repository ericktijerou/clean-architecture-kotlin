package android.erick.remote.model

/**
 * Created by ericktijero on 11/7/17.
 */
open class BaseResponse<T> {
    var info: InfoResponse? = null
    var results: T? = null
}