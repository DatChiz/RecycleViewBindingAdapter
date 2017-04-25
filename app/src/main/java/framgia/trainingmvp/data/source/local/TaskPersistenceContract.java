package framgia.trainingmvp.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by MyPC on 18/04/2017.
 */

public class TaskPersistenceContract {

    private TaskPersistenceContract() {
    }

    public class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "task";
        public static final String COLUM_NAME_TITLE = "title";
        public static final String COLUM_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }
}
