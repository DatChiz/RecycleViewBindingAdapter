package framgia.trainingmvp.srceen.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import framgia.trainingmvp.R;
import framgia.trainingmvp.data.source.TasksRepository;
import framgia.trainingmvp.databinding.ActivityMainBinding;

import framgia.trainingmvp.data.source.local.TaskLocalDataSource;

public class MainActivity extends AppCompatActivity {
    private MainContract.ViewModel mMainViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainViewModel = new MainViewModel(this);

        TasksRepository tasksRepository =
                new TasksRepository(TaskLocalDataSource.getInstance(getApplicationContext()));

        MainContract.Presenter presenter = new MainPresenter(mMainViewModel, tasksRepository);

        mMainViewModel.setPresenter(presenter);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel((MainViewModel) mMainViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainViewModel.onStart();
    }
}
