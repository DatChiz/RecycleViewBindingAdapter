package framgia.bindrecycle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import framgia.bindrecycle.adapter.UserAdapter;
import framgia.bindrecycle.model.User;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.userList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        users = new ArrayList<User>();
        users.add(new User("a", 1, Color.RED));
        users.add(new User("b", 2, Color.BLUE));
        users.add(new User("c", 3, Color.RED));
        users.add(new User("d", 4, Color.BLUE));

        UserAdapter userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
    }
}
