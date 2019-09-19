package com.mvvm.skelton.common;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by AblySoft Pvt Ltd. on 24/7/19.
 */
public class MyResponse<T> {
    public int tag;

    @NonNull
    public T data;

    @Nullable
    public Exception error;

    public boolean isLoading;

    public MyResponse(int tag, T data) {
        this.tag = tag;
        this.data = data;
    }

    public MyResponse(int tag, Exception error) {
        this.tag = tag;
        this.error = error;
    }

    public MyResponse(int tag, boolean isLoading) {
        this.tag = tag;
        this.isLoading = isLoading;
    }


}
