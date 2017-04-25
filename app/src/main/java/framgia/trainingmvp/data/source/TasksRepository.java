package framgia.trainingmvp.data.source;

import framgia.trainingmvp.data.model.Task;
import framgia.trainingmvp.data.source.local.TaskLocalDataSource;

/**
 * Created by MyPC on 18/04/2017.
 */

public class TasksRepository {
    private TaskLocalDataSource mTaskLocalDataSource;

    public TasksRepository(TaskLocalDataSource taskLocalDataSource) {
        mTaskLocalDataSource = taskLocalDataSource;
    }

    public TaskLocalDataSource getTaskLocalDataSource() {
        return mTaskLocalDataSource;
    }
}
