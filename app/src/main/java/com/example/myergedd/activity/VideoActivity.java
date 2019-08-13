package com.example.myergedd.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.myergedd.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class VideoActivity extends AppCompatActivity {

    private StandardGSYVideoPlayer mDetailPlayer;
    private String video;
    private String name;
    private OrientationUtils orientationUtils;
    private static final String TAG = "VideoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video = getIntent().getStringExtra("video");
        name = getIntent().getStringExtra("name");
        initView();
        Log.d(TAG, "onCreate: "+video);
        Log.d(TAG, "onCreate: "+name);
    }

    private void initView() {
        mDetailPlayer = (StandardGSYVideoPlayer) findViewById(R.id.detail_player);

//        mDetailPlayer.setUp("http://video5lmv.ergedd.com/videos/11234_r_480_20171122143537_5jjf.mp4",true,"123");
        mDetailPlayer.setUp(video,true,name);
        //增加title
        mDetailPlayer.getTitleTextView().setVisibility(View.VISIBLE);
        //设置返回键
        mDetailPlayer.getBackButton().setVisibility(View.VISIBLE);
        //设置旋转
        orientationUtils = new OrientationUtils(this, mDetailPlayer);
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        mDetailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
            }
        });
        //是否可以滑动调整
        mDetailPlayer.setIsTouchWiget(true);
        //设置返回按键功能
        mDetailPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mDetailPlayer.startPlayLogic();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mDetailPlayer.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDetailPlayer.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }
    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            mDetailPlayer.getFullscreenButton().performClick();
            return;
        }
        //释放所有
        mDetailPlayer.setVideoAllCallBack(null);
        super.onBackPressed();
    }
}
