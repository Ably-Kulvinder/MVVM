package com.journaldev.androidmvvmdatabindinglivedata.usersListController;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.journaldev.androidmvvmdatabindinglivedata.ServerUtils.Repository;
import com.journaldev.androidmvvmdatabindinglivedata.ServerUtils.ResponseHandler;

import retrofit2.Response;


public class UsersListViewModel extends ViewModel {

    private MutableLiveData<UsersList> usersList = new MutableLiveData<>();

    public UsersListViewModel() {
    }

    public void getUsers() {

         Repository.getInstance().getUsersList(1 , new ResponseHandler() {
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