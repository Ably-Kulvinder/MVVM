package com.mvvm.skelton.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.skelton.R;
import com.mvvm.skelton.databinding.ActivityMainBinding;
import com.mvvm.skelton.loginController.LoginViewModel;
import com.mvvm.skelton.loginController.User;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Thread.setDefaultUncaughtExceptionHandler(new ForceCloseHandler(this));

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);


        loginViewModel.getUser().observe(this, user -> {

            if (user.isLoading) {
                showProgress(false);
                return;
            } else
                hideProgress();


            if (user.error == null) {
                User usr = (User) user.data;
                Toast.makeText(getApplicationContext(), "Login successfully with token " + usr.getmToken(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ContentActivity.class));
            } else
                Toast.makeText(getApplicationContext(), "Login failed " + user.error, Toast.LENGTH_SHORT).show();

        });

    }

}
