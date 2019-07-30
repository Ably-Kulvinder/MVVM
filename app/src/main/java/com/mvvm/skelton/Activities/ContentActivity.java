package com.journaldev.androidmvvmdatabindinglivedata.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.journaldev.androidmvvmdatabindinglivedata.R;
import com.journaldev.androidmvvmdatabindinglivedata.adapters.UsersListAdapter;
import com.journaldev.androidmvvmdatabindinglivedata.databinding.ContentContentBinding;
import com.journaldev.androidmvvmdatabindinglivedata.usersListController.UsersListViewModel;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContentContentBinding binding = DataBindingUtil.setContentView(this, R.layout.content_content);
        UsersListViewModel usersViewModel = ViewModelProviders.of(this).get(UsersListViewModel.class);
        usersViewModel.getUsers();

        usersViewModel.getUser().observe(this, user -> {

            UsersListAdapter myRecyclerViewAdapter = new UsersListAdapter(user.getData());
        /*   binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
             binding.myRecyclerView.addItemDecoration(
             new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/

            binding.setUsersListAdapter(myRecyclerViewAdapter);
           // binding.executePendingBindings();

        });
    }
}
