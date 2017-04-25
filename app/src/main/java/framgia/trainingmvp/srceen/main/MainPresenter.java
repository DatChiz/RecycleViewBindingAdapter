package framgia.trainingmvp.srceen.main;

import android.text.TextUtils;

import framgia.trainingmvp.data.source.TasksRepository;
import java.util.List;

import framgia.trainingmvp.data.model.Task;
import framgia.trainingmvp.data.source.TasksDataSoure;

/**
 * Created by MyPC on 18/04/2017.
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.ViewModel mViewModel;
    private TasksRepository mTasksRepository;


    public MainPresenter(MainContract.ViewModel viewModel, TasksRepository tasksRepository){
        mViewModel = viewModel;
        mTasksRepository = tasksRepository;
    }

    @Override
    public void saveTask(String title, String description) {
        if (TextUtils.isEmpty(title) ||TextUtils.isEmpty(description)){
            mViewModel.onSaveTaskError();
        } else {
            creatTask(title, description);
        }
    }

    @Override
    public void onStart() {
        mTasksRepository.getTaskLocalDataSource().getTasks(new TasksDataSoure.LoadTaskCallBack() {
            @Override
            public void onTaskLoaded(List<Task> tasks) {
                mViewModel.showListTask(tasks);
            }

            @Override
            public void onNotDataAvailable() {

            }
        });
    }

    @Override
    public void deleteTask(String taskId) {
        if (mTasksRepository.getTaskLocalDataSource().deleteTask(taskId)){
            mViewModel.onRemoveTaskSuccess(taskId);
        }else {
            mViewModel.onRemoveTaskFailed();
        }
    }

    private void creatTask(String title, String description){
        Task task = new Task(title, description);
        if (mTasksRepository.getTaskLocalDataSource().saveTask(task)){
            mViewModel.addTaskToList(task);
        } else {
            mViewModel.addTaskToListError();
        }
    }
}
