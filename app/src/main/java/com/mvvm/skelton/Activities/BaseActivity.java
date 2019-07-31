package com.mvvm.skelton.Activities;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.mvvm.skelton.R;
import java.util.Objects;

/**
 * Created by AblySoft Pvt Ltd. on 31/7/19.
 */
public class BaseActivity extends AppCompatActivity {
    private AlertDialog LoadingDialog;
    public void showProgress(boolean isCancelable) {
        if (isFinishing()) return;

        if (LoadingDialog != null)
            LoadingDialog.dismiss();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater li = LayoutInflater.from(getBaseContext());
        @SuppressLint("InflateParams") View promptsView = li.inflate(R.layout.myprogress, null);
        builder.setView(promptsView);
        LoadingDialog = builder.create();
        try {
            Objects.requireNonNull(LoadingDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            LoadingDialog.setCanceledOnTouchOutside(isCancelable);
            LoadingDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void hideProgress() {
        try {
            if (!isFinishing()) {
                if (LoadingDialog != null)
                    LoadingDialog.dismiss();
            }
        } catch (Exception ignored) {
        }
    }
}
