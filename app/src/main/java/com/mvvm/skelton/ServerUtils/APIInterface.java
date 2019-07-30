package com.mvvm.skelton.ServerUtils;


import com.mvvm.skelton.loginController.User;
import com.mvvm.skelton.usersListController.UsersList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by AblySoft Pvt Ltd. on 09/01/17.
 */

interface APIInterface {


    @FormUrlEncoded
    @POST("/api/login")
    Call<User> login(@Field("email") String email, @Field("password") String password);

     @GET("/api/users?page=2")
    Call<UsersList> getUsers();






}

