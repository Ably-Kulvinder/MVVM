package com.mvvm.skelton.ServerUtils;


import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

/**
 * Created by AblySoft Pvt Ltd. on 18/7/19.
 */
public class DataUtils {

    public static String showUppercase(String text){
        return text.toUpperCase().concat("   **   ");
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Log.d(TAG, "loadImage: " + url);
        Picasso.get().load(url).into(imageView);
    }

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("app:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    /* @BindingAdapter("android:onTextChanged")
     public static void setListener(TextView view, OnTextChanged onTextChanged) {
         setListener(view, null, onTextChanged, null);
     }*/

 /*   @BindingAdapter({"android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged"})
    public static void setListener(TextView view, final BeforeTextChanged before,
                                   final OnTextChanged on, final AfterTextChanged after) {
        final TextWatcher newValue;
        if (before == null && after == null && on == null) {
            newValue = null;
        } else {
            newValue = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (before != null) {
                        before.beforeTextChanged(s, start, count, after);
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (on != null) {
                        on.onTextChanged(s, start, before, count);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (after != null) {
                        after.afterTextChanged(s);
                    }
                }
            };
        }
        final TextWatcher oldValue = ListenerUtil.trackListener(view, newValue, R.id.textWatcher);
        if (oldValue != null) {
            view.removeTextChangedListener(oldValue);
        }
        if (newValue != null) {
            view.addTextChangedListener(newValue);
        }
    }

    public interface AfterTextChanged {
        void afterTextChanged(Editable s);
    }

    public interface BeforeTextChanged {
        void beforeTextChanged(CharSequence s, int start, int count, int after);
    }

    public interface OnTextChanged {
        void onTextChanged(CharSequence s, int start, int before, int count);
    }
*/}
