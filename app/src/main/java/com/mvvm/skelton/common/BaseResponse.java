package com.mvvm.skelton.common;

/**
 * Created by AblySoft Pvt Ltd. on 24/7/19.
 */
public class BaseResponse<T> {

    private T  items ;

    public void BaseResponse(T item){
        items=item;
    }

}
