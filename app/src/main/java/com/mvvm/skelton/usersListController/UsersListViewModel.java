package com.mvvm.skelton.usersListController;

import android.util.Log;

import com.mvvm.skelton.ServerUtils.Repository;
import com.mvvm.skelton.ServerUtils.ResponseHandler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Response;


public class UsersListViewModel extends ViewModel {

    private MutableLiveData<UsersList> usersList = new MutableLiveData<>();

    public UsersListViewModel() {
    }

    public void getUsers() {

        Repository.getInstance().getUsersList(1, new ResponseHandler() {
            @Override
            public void onSuccess(int tag, Response response) {
                usersList.setValue((UsersList) response.body());
            }

            @Override
            public void onFailur(Exception t) {
                Log.d("", "onFailure: ");
            }
        });

    }

    public LiveData<UsersList> getUser() {
        if (usersList == null) {
            usersList = new MutableLiveData<>();
        }
        return usersList;
    }
}