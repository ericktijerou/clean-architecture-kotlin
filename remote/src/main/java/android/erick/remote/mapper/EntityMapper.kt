package android.erick.remote.mapper

/**
 * Created by ericktijero on 11/7/17.
 */
interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}