package framgia.trainingmvp.data.source;

import java.util.List;

import framgia.trainingmvp.data.model.Task;

/**
 * Created by MyPC on 18/04/2017.
 */

public interface TasksDataSoure {

    interface LoadTaskCallBack{

        void onTaskLoaded(List<Task> tasks);

        void onNotDataAvailable();
    }

    interface GetTaskCallBack{

        void onTaskLoaded(Task task);

        void onDataAvailable();
    }

    void getTasks(LoadTaskCallBack callBack);

    void getTask(String taskId, GetTaskCallBack callBack);

    Boolean saveTask(Task task);

    void editTask(Task task);

    Boolean deleteTask(String taskId);
}
