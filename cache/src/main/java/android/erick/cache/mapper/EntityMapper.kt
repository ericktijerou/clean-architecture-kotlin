package android.erick.cache.mapper

/**
 * Created by ericktijero on 11/9/17.
 */
interface EntityMapper<T, V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T

}