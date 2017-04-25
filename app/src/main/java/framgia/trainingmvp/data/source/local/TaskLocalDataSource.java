package framgia.trainingmvp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import framgia.trainingmvp.data.model.Task;
import framgia.trainingmvp.data.source.TasksDataSoure;
import framgia.trainingmvp.data.source.local.TaskPersistenceContract.TaskEntry;

/**
 * Created by MyPC on 18/04/2017.
 */

public class TaskLocalDataSource implements TasksDataSoure {

    private static TaskLocalDataSource INSTANCE;

    private TaskDbHelper dbHelper;

    private TaskLocalDataSource(Context context){
        dbHelper = new TaskDbHelper(context);
    }

    public static TaskLocalDataSource getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new TaskLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getTasks(@NonNull LoadTaskCallBack callBack) {

        List<Task> tasks = new ArrayList<Task>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String [] projection = {
                TaskEntry.COLUM_NAME_ENTRY_ID,
                TaskEntry.COLUM_NAME_TITLE,
                TaskEntry.COLUMN_NAME_DESCRIPTION
        };

        Cursor c = db.query(TaskEntry.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0){
            while (c.moveToNext()){
                Task task = new Task(c);
                tasks.add(task);
            }
        }

        if (c != null){
            c.close();
        }

        db.close();

        if (tasks.isEmpty()){
            callBack.onNotDataAvailable();
        } else {
            callBack.onTaskLoaded(tasks);
        }
    }

    @Override
    public void getTask(String taskId, GetTaskCallBack callBack) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String [] projection = {
                TaskEntry.COLUM_NAME_ENTRY_ID,
                TaskEntry.COLUM_NAME_TITLE,
                TaskEntry.COLUMN_NAME_DESCRIPTION
        };

        String selection = TaskEntry.COLUM_NAME_ENTRY_ID + " LIKE ?";
        String[] selectionArgs = { taskId };

        Cursor c = db.query(
                TaskEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        Task task = null;

        if (c != null && c.getCount() > 0){
            c.moveToFirst();
            task = new Task(c);
        }

        if (c != null){
            c.close();
        }

        db.close();

        if (task != null){
            callBack.onDataAvailable();
        } else {
            callBack.onTaskLoaded(task);
        }
    }

    @Override
    public Boolean saveTask(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskEntry.COLUM_NAME_ENTRY_ID, task.getId());
        values.put(TaskEntry.COLUM_NAME_TITLE, task.getTitle());
        values.put(TaskEntry.COLUMN_NAME_DESCRIPTION, task.getDescription());


        long rowIndex = db.insert(TaskEntry.TABLE_NAME, null, values);

        db.close();

        return rowIndex > 0;
    }

    @Override
    public void editTask(Task task) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskEntry.COLUM_NAME_TITLE, task.getTitle());
        values.put(TaskEntry.COLUMN_NAME_DESCRIPTION, task.getDescription());

        String selection = TaskEntry.COLUM_NAME_ENTRY_ID + " LIKE ?";
        String[] selectionArgs = { task.getId() };

        db.update(TaskEntry.TABLE_NAME, values, selection, selectionArgs);

        db.close();
    }

    @Override
    public Boolean deleteTask(String taskId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = TaskEntry.COLUM_NAME_ENTRY_ID + " LIKE ?";
        String[] selectionArgs = { taskId };

        long rowIndex = db.delete(TaskEntry.TABLE_NAME, selection, selectionArgs);

        db.close();

        return rowIndex > 0;
    }
}
