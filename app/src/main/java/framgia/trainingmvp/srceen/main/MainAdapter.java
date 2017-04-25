package framgia.trainingmvp.srceen.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import framgia.trainingmvp.BR;
import framgia.trainingmvp.data.model.Task;
import framgia.trainingmvp.databinding.TaskRowBinding;
import java.util.List;

/**
 * Created by MyPC on 25/04/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.TaskHolder> {
    private List<Task> mTasks;

    public MainAdapter(List<Task> tasks) {
        mTasks = tasks;
    }

    public void replaceTask(List<Task> newItems){
        mTasks = newItems;
        notifyDataSetChanged();
    }

    public void addTask(Task newItem){
        mTasks.add(newItem);
        notifyDataSetChanged();
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TaskRowBinding taskRowBinding = TaskRowBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new TaskHolder(taskRowBinding);
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, final int position) {
        holder.bindData(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public void removeTask(String taskId) {
        for (int i = 0; i < mTasks.size(); i++){
            if (taskId.equals(mTasks.get(i).getId())){
                mTasks.remove(i);
            }
        }
        notifyDataSetChanged();
    }

    public class TaskHolder extends RecyclerView.ViewHolder{
        private TaskRowBinding mBinding;

        public TaskHolder(TaskRowBinding taskRowBinding) {
            super(taskRowBinding.getRoot());
            mBinding = taskRowBinding;
        }

        public void bindData(Task task){
            mBinding.setVariable(BR.task, task);
            mBinding.executePendingBindings();
        }
    }
}
