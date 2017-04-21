package framgia.bindrecycle;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import framgia.bindrecycle.adapter.UserAdapter;
import framgia.bindrecycle.databinding.ActivityMainBinding;
import framgia.bindrecycle.model.User;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new MainViewModel(this);
        binding.setMain(mainViewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<User> users = new ArrayList<User>();
        users.add(new User("a", 1, Color.RED));
        users.add(new User("b", 2, Color.BLUE));
        users.add(new User("c", 3, Color.RED));
        users.add(new User("d", 4, Color.BLUE));

        mainViewModel.setData(users);
    }
}
