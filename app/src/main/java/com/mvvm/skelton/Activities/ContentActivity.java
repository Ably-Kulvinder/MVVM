package com.mvvm.skelton.Activities;


import android.os.Bundle;

import com.mvvm.skelton.R;
import com.mvvm.skelton.adapters.UsersListAdapter;
import com.mvvm.skelton.databinding.ContentContentBinding;
import com.mvvm.skelton.usersListController.UsersListViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentContentBinding binding = DataBindingUtil.setContentView(this, R.layout.content_content);
        UsersListViewModel usersViewModel = ViewModelProviders.of(this).get(UsersListViewModel.class);
        usersViewModel.getUsers();

        usersViewModel.getUser().observe(this, user -> {

            UsersListAdapter myRecyclerViewAdapter = new UsersListAdapter(user.getData());
            binding.setUsersListAdapter(myRecyclerViewAdapter);

        /*   binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
             binding.myRecyclerView.addItemDecoration(
             new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/
            // binding.executePendingBindings();

        });
    }
}
