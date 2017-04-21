package framgia.bindrecycle;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import framgia.bindrecycle.adapter.UserAdapter;
import framgia.bindrecycle.model.RecyclerConfiguration;
import framgia.bindrecycle.model.User;

/**
 * Created by MyPC on 21/04/2017.
 */

public class MainViewModel {
    private Context mContext;
    public final RecyclerConfiguration recyclerConfiguration = new RecyclerConfiguration();
    private UserAdapter userAdapter = new UserAdapter(new ArrayList<User>());

    public MainViewModel(Context context) {
        this.mContext = context;
        initRecycler();
    }

    public void setData(List<User> user){
        userAdapter.setUsers(user);
    }

    private void initRecycler(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerConfiguration.setLayoutManager(layoutManager);
        recyclerConfiguration.setAdapter(userAdapter);
    }
}
