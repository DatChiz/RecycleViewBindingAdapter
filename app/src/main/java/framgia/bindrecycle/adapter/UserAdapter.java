package framgia.bindrecycle.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import framgia.bindrecycle.BR;
import framgia.bindrecycle.R;
import framgia.bindrecycle.databinding.ItemRowBinding;
import framgia.bindrecycle.model.User;

/**
 * Created by MyPC on 21/04/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> mUsers;

    public UserAdapter(List<User> users) {
        this.mUsers = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRowBinding itemRowBinding = ItemRowBinding
                .inflate(LayoutInflater.from(parent.getContext()));
        return new UserViewHolder(itemRowBinding);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(List<User> users){
        mUsers = users;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ItemRowBinding binding;

        public UserViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            binding = itemRowBinding;
        }

        public void bindData(User user){
            binding.setVariable(BR.user, user);
            binding.executePendingBindings();
        }
    }
}
