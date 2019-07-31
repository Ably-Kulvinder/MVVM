package com.mvvm.skelton.loginController;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.mvvm.skelton.ServerUtils.BaseModel;
import com.mvvm.skelton.ServerUtils.Repository;
import com.mvvm.skelton.ServerUtils.ResponseHandler;
import com.mvvm.skelton.common.MyResponse;

import retrofit2.Response;


public class LoginViewModel extends BaseModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public ObservableField<String> emailError = new ObservableField<>();
    public ObservableField<String> passwordError = new ObservableField<>();

    private MutableLiveData<MyResponse> loginData = new MutableLiveData<>();

    public LoginViewModel() {
    }

    public void onLoginClicked() {
       //email.setValue("eve.holt@reqres.in");
      //password.setValue("acityslicka");
        if (!isValidCredential())
            return;
        loginData.setValue(new MyResponse(1, true));

        Repository.getInstance().login(1, email.getValue(), password.getValue(), new ResponseHandler() {
            @Override
            public void onSuccess(int tag, Response response) {
                if (response.body() != null)
                    loginData.setValue(new MyResponse(1, response.body()));
                else
                    loginData.setValue(new MyResponse(1, new Exception("Something went wrong!")));
            }

            @Override
            public void onFailur(Exception t) {
                loginData.setValue(new MyResponse(1, t));
            }
        });
    }

    private boolean isValidCredential() {

        if (email.getValue() == null || email.getValue().toString().length() <= 5) {
            emailError.set("email length too short");
            return false;
        } else{
            emailError.set(null);
        }
        if (password.getValue() == null || password.getValue().toString().length() <= 5) {
            passwordError.set("password length too short");
            return false;
        } else
            passwordError.set(null);

        return true;
    }

    public LiveData<MyResponse> getUser() {
        if (loginData == null) {
            loginData = new MutableLiveData<>();
        }
        return loginData;
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        isValidCredential();
    }
}