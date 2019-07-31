package com.mvvm.skelton.ServerUtils;

import retrofit2.Response;

/**
 * Created by kulvinder Singh on 29/11/17.
 */


public interface ResponseHandler {

     void onSuccess(int tag, Response response);
     void onFailur(Exception t);
}
