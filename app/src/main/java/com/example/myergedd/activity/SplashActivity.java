package com.example.myergedd.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.myergedd.MainActivity;
import com.example.myergedd.R;
import com.example.myergedd.base.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class SplashActivity extends SimpleActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        final MediaPlayer player = MediaPlayer.create(this, R.raw.ergedd_introduce);
        player.start();
        new CountDownTimer(player.getDuration() + 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
