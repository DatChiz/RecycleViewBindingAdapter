package framgia.trainingmvp.data.model;

import android.database.Cursor;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import framgia.trainingmvp.BR;
import java.util.UUID;

import framgia.trainingmvp.data.source.local.TaskPersistenceContract;

/**
 * Created by MyPC on 18/04/2017.
 */

public class Task extends BaseObservable{
    private String mTitle;

    private String mDescription;

    private String mId;

    public Task(String title, String description) {
        this(title, description, UUID.randomUUID().toString());
    }

    public Task(String title, String description, String id) {
        this.mTitle = title;
        this.mDescription = description;
        this.mId = id;
    }

    public Task(Cursor cursor){
        mId = cursor.getString(cursor.getColumnIndexOrThrow(
                        TaskPersistenceContract.TaskEntry.COLUM_NAME_ENTRY_ID));
        mTitle = cursor.getString(cursor.getColumnIndexOrThrow(
                        TaskPersistenceContract.TaskEntry.COLUM_NAME_TITLE));
        mDescription = cursor.getString(cursor.getColumnIndexOrThrow(
                        TaskPersistenceContract.TaskEntry.COLUMN_NAME_DESCRIPTION));
    }

    @Bindable
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
        notifyPropertyChanged(BR.id);
    }
}
