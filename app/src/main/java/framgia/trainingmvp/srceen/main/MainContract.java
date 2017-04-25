package framgia.trainingmvp.srceen.main;

import java.util.List;

import framgia.trainingmvp.data.model.Task;

/**
 * Created by MyPC on 18/04/2017.
 */

public interface MainContract {

    interface ViewModel {
        void addTaskToList(Task task);

        void onSaveTaskError();

        void onSaveTaskSuccessful(String title);

        void showListTask(List<Task> tasks);

        void onRemoveTaskSuccess(String taskId);

        void onRemoveTaskFailed();

        void setPresenter(Presenter presenter);

        void addTaskToListError();

        void onStart();
    }

    interface Presenter {
        void saveTask(String title, String description);

        void onStart();

        void deleteTask(String taskId);
    }
}
