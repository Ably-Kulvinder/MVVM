package com.journaldev.androidmvvmdatabindinglivedata.ServerUtils;


import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by AblySoft Pvt Ltd. on 29/11/17.
 */

class APIClient {

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Interceptor intercept = chain -> {
            Request request = chain.request().newBuilder().header("X-TOKEN","QpwL5tke4Pnpja7X4")
                    .header("X-USER-TYPE", "1").build();
            return chain.proceed(request);
        };

        OkHttpClient client = enableTls12OnPreLollipop(new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS). addInterceptor(intercept).addInterceptor(interceptor));


        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    private static OkHttpClient enableTls12OnPreLollipop(OkHttpClient.Builder client) {
        return client.build();
    }

}
