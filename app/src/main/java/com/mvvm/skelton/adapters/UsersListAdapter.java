package com.journaldev.androidmvvmdatabindinglivedata.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.journaldev.androidmvvmdatabindinglivedata.R;
import com.journaldev.androidmvvmdatabindinglivedata.databinding.ListItemUsersBinding;
import com.journaldev.androidmvvmdatabindinglivedata.usersListController.UsersList;

import java.util.List;


/**
 * Created by AblySoft Pvt Ltd. on 20/2/18.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder>
         {

    private List<UsersList.Datum> usersList;

    public UsersListAdapter(List<UsersList.Datum> data) {

        this.usersList = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemUsersBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.list_item_users, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UsersList.Datum item = usersList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ListItemUsersBinding binding;

        public ViewHolder(@NonNull ListItemUsersBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(UsersList.Datum item) {
            binding.setUser(item);
            binding.executePendingBindings();
        }
    }
             public void selected(UsersList.Datum f) {
                // Toast.makeText(c, "You clicked " + f.androidName,
                    //     Toast.LENGTH_LONG).show();
             }

}