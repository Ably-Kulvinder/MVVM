package com.mvvm.skelton.ServerUtils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.content.ContentValues.TAG;

/**
 * Created by AblySoft Pvt Ltd. on 18/7/19.
 */
public class DataUtils {

    /*    @BindingAdapter("app:rb_count")
        public static void setImage(RatingBar ratingBar, Integer count) {
            if(count!=null)ratingBar.setCount(count);
        }*/
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        //   Picasso.getInstance().downloadImage(distributorFilteredList.get(position).getUserImage(), holder.photoIV, ContextCompat.getDrawable(ctx, R.drawable.shop_placeholder));
        Log.d(TAG, "loadImage: "+url);
        Picasso.get().load(url).into(imageView);
    }



    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

}
