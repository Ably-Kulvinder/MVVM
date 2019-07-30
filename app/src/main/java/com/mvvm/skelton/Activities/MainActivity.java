package com.journaldev.androidmvvmdatabindinglivedata.Activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.journaldev.androidmvvmdatabindinglivedata.R;
import com.journaldev.androidmvvmdatabindinglivedata.databinding.ActivityMainBinding;
import com.journaldev.androidmvvmdatabindinglivedata.loginController.LoginViewModel;
import com.journaldev.androidmvvmdatabindinglivedata.loginController.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        loginViewModel.getUser().observe(this, user -> {


                if (user.error == null) {
                    User  usr = (User) user.data;
                    Toast.makeText(getApplicationContext(), "Login successfully with token " + usr.getmToken(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ContentActivity.class));
                } else
                    Toast.makeText(getApplicationContext(), "Login failed " + user.error, Toast.LENGTH_SHORT).show();

        });

    }

}
