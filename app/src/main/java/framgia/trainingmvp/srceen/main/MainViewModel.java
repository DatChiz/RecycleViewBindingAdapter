package framgia.trainingmvp.srceen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import framgia.trainingmvp.BR;
import framgia.trainingmvp.data.model.Task;
import java.util.List;

/**
 * Created by MyPC on 25/04/2017.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel{
    private String mInputTitle;
    private String mInputDescription;

    private MainContract.Presenter mPresenter;

    private Context mContext;
    private MainAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public MainViewModel(Context context) {
        this.mContext = context;
    }

    private void initRecycler(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        setLayoutManager(layoutManager);
        setAdapter(mAdapter);
    }

    public void onAddTask(){
        mPresenter.saveTask(mInputTitle, mInputDescription);
    }

    @Bindable
    public MainAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(MainAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        notifyPropertyChanged(BR.layoutManager);
    }

    @Bindable
    public String getInputTitle() {
        return mInputTitle;
    }

    public void setInputTitle(String inputTitle) {
        mInputTitle = inputTitle;
        notifyPropertyChanged(BR.inputTitle);
    }

    @Bindable
    public String getInputDescription() {
        return mInputDescription;
    }

    public void setInputDescription(String inputDescription) {
        mInputDescription = inputDescription;
        notifyPropertyChanged(BR.inputDescription);
    }

    @Override
    public void addTaskToList(Task task) {
        mAdapter.addTask(task);
    }

    @Override
    public void onSaveTaskError() {

    }

    @Override
    public void onSaveTaskSuccessful(String title) {

    }

    @Override
    public void showListTask(List<Task> tasks) {
        if (mAdapter == null){
            mAdapter = new MainAdapter(tasks);
            initRecycler();
        } else {
            mAdapter.replaceTask(tasks);
        }
    }

    @Override
    public void onRemoveTaskSuccess(String taskId) {
        mAdapter.removeTask(taskId);
    }

    @Override
    public void onRemoveTaskFailed() {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addTaskToListError() {

    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }
}
