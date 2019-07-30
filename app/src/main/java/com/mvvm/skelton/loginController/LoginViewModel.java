package com.journaldev.androidmvvmdatabindinglivedata.loginController;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.journaldev.androidmvvmdatabindinglivedata.ServerUtils.BaseModel;
import com.journaldev.androidmvvmdatabindinglivedata.ServerUtils.Repository;
import com.journaldev.androidmvvmdatabindinglivedata.ServerUtils.ResponseHandler;
import com.journaldev.androidmvvmdatabindinglivedata.common.MyResponse;

import retrofit2.Response;


public class LoginViewModel extends BaseModel{
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    private MutableLiveData<MyResponse> loginData = new MutableLiveData<>();

    public LoginViewModel() {
    }

    public void onLoginClicked() {
      //  email.setValue("eve.holt@reqres.in");
      //  password.setValue("acityslicka");

         Repository.getInstance().login(1, email.getValue(), password.getValue(), new ResponseHandler() {

             @Override
             public void onSuccess(int tag, Response response) {
                 if(response.body()!=null)
                     loginData.setValue(new MyResponse(1, response.body()));
                 else
                     loginData.setValue(new MyResponse(1,new Exception("Something went wrong!")));
             }

             @Override
            public void onFailur(Exception t) {
                loginData.setValue(new MyResponse(1,t));
            }
        });
    }

    public LiveData<MyResponse> getUser() {
        if (loginData == null) {
            loginData = new MutableLiveData<>();
        }
        return loginData;
    }

}