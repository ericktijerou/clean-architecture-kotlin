package android.erick.cache.db.mapper

import android.content.ContentValues
import android.database.Cursor
import android.erick.cache.db.Db
import android.erick.cache.model.CachedName
import android.erick.cache.model.CachedPicture
import android.erick.cache.model.CachedUser
import javax.inject.Inject

/**
 * Created by ericktijero on 11/9/17.
 */
class UserMapper @Inject constructor(): ModelDbMapper<CachedUser> {

    /**
     * Construct an instance of [ContentValues] using the given [CachedBufferoo]
     */
    override fun toContentValues(model: CachedUser): ContentValues {
        val values = ContentValues()
        values.put(Db.UsersTable.NAME, model.name.first)
        values.put(Db.UsersTable.TITLE, model.name.title)
        values.put(Db.UsersTable.AVATAR, model.picture.medium)
        return values
    }

    /**
     * Parse the cursor creating a [CachedBufferoo] instance.
     */
    override fun parseCursor(cursor: Cursor): CachedUser {
        val name = CachedName(cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.NAME)), cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.NAME)), cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.NAME)))
        val title = cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.TITLE))
        val picture = CachedPicture(cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.AVATAR)), cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.AVATAR)), cursor.getString(cursor.getColumnIndexOrThrow(Db.UsersTable.AVATAR)))
        return CachedUser(name, title, picture)
    }

}