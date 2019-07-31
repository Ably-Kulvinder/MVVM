package com.mvvm.skelton.ServerUtils;


import com.mvvm.skelton.loginController.User;
import com.mvvm.skelton.usersListController.UsersList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AblySoft Pvt Ltd. on 7/7/17.
 */

public class Repository {

    private static Repository holder;

    private APIInterface apiInterface = null;


    private Repository() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    public static Repository getInstance() {
        if (holder == null)
            holder = new Repository();
        return holder;
    }

    public  void login(final int i, String userName, String Password, final ResponseHandler listner) {
        assert apiInterface != null;
        Call<User> call1 = apiInterface.login(userName,Password);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (listner != null) {
                    if (response.isSuccessful())
                        listner.onSuccess(i, response);
                    else
                        listner.onFailur(new Exception(response.message()));
                }
            }


            @Override
            public void onFailure(  Call<User> call, Throwable t) {
                call.cancel();
                if (listner != null)
                    listner.onFailur(new Exception(t.getLocalizedMessage()));
            }

        });

    }
    public  void getUsersList (final int i, ResponseHandler listner) {
        assert apiInterface != null;
        Call<UsersList> call1 = apiInterface.getUsers();
        call1.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                if (listner != null) {
                    if (response.isSuccessful())
                        listner.onSuccess(i, response);
                    else
                        listner.onFailur(null);
                }
            }

            @Override
            public void onFailure(  Call<UsersList> call, Throwable t) {
                call.cancel();
                if (listner != null)
                    listner.onFailur(new Exception(t.getLocalizedMessage()));
            }
        });
    }

}
