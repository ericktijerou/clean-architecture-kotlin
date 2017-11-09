package android.erick.data.mapper

/**
 * Created by ericktijero on 11/8/17.
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}