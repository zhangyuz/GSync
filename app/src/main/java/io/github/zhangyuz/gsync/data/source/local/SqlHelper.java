package io.github.zhangyuz.gsync.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

public class SqlHelper extends SQLiteOpenHelper {

    private static final String TAG = "SqlHelper";

    private static final String sDbName = "gsync.db";
    private static final int sDbVersion = 1;
    private static final String sSvTabbleName = "kvmaps";
    private static final String sKvTabbleColumnK = "key";
    private static final String sKvTabbleColunmV = "value";

    public SqlHelper(Context context) {
        this(context, sDbName, null, sDbVersion, null);
    }

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                     int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE kvmaps (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "key TEXT UNIQUE ON CONFLICT REPLACE," +
                "value TEXT" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i(TAG, String.format("DB upgrade from %d to %d", i, i1));
    }

    /**
     * Get key from table
     *
     * @param key The key
     * @return The value or null on non-exists
     */
    public String get(final String key) {
        if (TextUtils.isEmpty(key)) {
            throw new IllegalArgumentException("Empty key");
        }
        Cursor cursor = null;
        try {
            final SQLiteDatabase db = getReadableDatabase();
            cursor = db.query(sSvTabbleName, new String[]{sKvTabbleColunmV}, "key = ?",
                    new String[]{key}, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                return cursor.getString(0);
            }
        } catch (SQLiteException e) {
            Log.e(TAG, "Failed to get value for " + key, e);
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return null;
    }

    public void save(final String key, final String value) {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            throw new IllegalArgumentException("Empty key or value");
        }
        try {
            final SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(sKvTabbleColumnK, key);
            values.put(sKvTabbleColunmV, value);
            db.insertOrThrow(sSvTabbleName, null, values);
        } catch (SQLiteException e) {
            Log.w(TAG, "Failed to open database", e);
        } catch (SQLException e) {
            Log.w(TAG, "Failed to save data");
        }
    }

}
