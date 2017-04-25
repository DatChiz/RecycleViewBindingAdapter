package framgia.trainingmvp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MyPC on 18/04/2017.
 */

public class TaskDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Tasks2.db";

    public static final String TEXT_TYPE = " TEXT";

    public static final String INT_TYPE = " INTEGER";

    public static final String COMMA_SEP = ",";


    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TaskPersistenceContract.TaskEntry.TABLE_NAME + " (" +
                    TaskPersistenceContract.TaskEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    TaskPersistenceContract.TaskEntry.COLUM_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    TaskPersistenceContract.TaskEntry.COLUM_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    TaskPersistenceContract.TaskEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE +
            ")";

    public TaskDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
