package io.github.liuwang.magicoder.home;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.liuwang.magicoder.R;

public class ShowPhotoActivity extends AppCompatActivity {
    private static final String EXTRA_PHOTO_URL = "img_url";
    private ImageView mImage;
    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        handleIntent();
        mImage = (ImageView) findViewById(R.id.iv_photo_detail);
        initData();
    }

    private void initData() {
        Glide.with(this).load(imgUrl).into(mImage);
    }

    private void handleIntent() {
        Intent data = getIntent();
        if (data != null) {
            imgUrl = data.getStringExtra(EXTRA_PHOTO_URL);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void startTargetActivity(Activity activity, String imgUrl, View view) {
        Intent intent = new Intent(activity, ShowPhotoActivity.class);
        intent.putExtra(EXTRA_PHOTO_URL, imgUrl);
        String shareView = activity.getResources().getString(R.string.girl_image);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(activity, view, shareView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.startActivity(intent, options.toBundle());
        } else {
            activity.startActivity(intent);
        }
    }
}
