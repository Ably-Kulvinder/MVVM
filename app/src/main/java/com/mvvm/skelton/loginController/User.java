package com.mvvm.skelton.loginController;


import android.util.Patterns;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    public String mEmail;
    public String mPassword;

    @SerializedName("token")
    @Expose
    private String mToken;

    @SerializedName("error")
    @Expose
    private String error;

    public User(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {

        this.mEmail = password;
    }

    public String getmToken() {
        return mToken;
    }

    public void setmToken(String mToken) {
        this.mToken = mToken;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}

