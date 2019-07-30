package com.mvvm.skelton.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by AblySoft Pvt Ltd. on 24/7/19.
 */
public class MyResponse<T>   {
    public int tag;

    @NonNull
    public   T data;

    @Nullable
    public Exception error;

    public MyResponse(int tag, @android.support.annotation.NonNull T data) {
        this.tag = tag;
        this.data = data;
    }

    public MyResponse(int tag,Exception error) {
        this.tag = tag;
        this.error = error;
    }


}
