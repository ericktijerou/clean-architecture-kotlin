package android.erick.cache.db

/**
 * Created by ericktijero on 11/9/17.
 */
object Db {

    object UsersTable {
        const val TABLE_NAME = "bufferroos"

        const val BUFFEROO_ID = "bufferoo_id"
        const val NAME = "name"
        const val TITLE = "title"
        const val AVATAR = "avatar"

        const val CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        BUFFEROO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        NAME + " TEXT NOT NULL," +
                        TITLE + " TEXT," +
                        AVATAR + " TEXT" +
                        "); "
    }

}