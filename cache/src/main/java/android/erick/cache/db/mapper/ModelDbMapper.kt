package android.erick.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor

/**
 * Created by ericktijero on 11/9/17.
 */
interface ModelDbMapper<T> {

    /**
     * Converts the model into ContentValues for the database table
     */
    fun toContentValues(model: T): ContentValues

    /**
     * Parses the Cursor resulting from a database query into the java model
     */
    fun parseCursor(cursor: Cursor): T

}