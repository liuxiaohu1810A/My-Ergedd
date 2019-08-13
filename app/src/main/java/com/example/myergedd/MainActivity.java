package com.example.myergedd;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myergedd.base.SimpleActivity;
import com.example.myergedd.fragment.CacheFragment;
import com.example.myergedd.fragment.see.SeeFragment;
import com.example.myergedd.fragment.hear.HearFragment;
import com.example.myergedd.utils.ShowFragmentUtils;
import com.example.myergedd.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends SimpleActivity {
    @BindView(R.id.rlayout_main_phone_container)
    FrameLayout mRlayoutMainPhoneContainer;
    @BindView(R.id.play_history)
    ViewStub mPlayHistory;
    @BindView(R.id.diviver)
    View mDiviver;
    @BindView(R.id.btn_phone_main_video)
    RadioButton mBtnPhoneMainVideo;
    @BindView(R.id.btn_phone_main_audio)
    RadioButton mBtnPhoneMainAudio;
    @BindView(R.id.btn_phone_main_profile)
    RadioButton mBtnPhoneMainProfile;
    @BindView(R.id.rgroup_main_phone_tab)
    RadioGroup mRgroupMainPhoneTab;
    private static boolean isExit = false;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    protected void initView() {
        ShowFragmentUtils.addFragment(getSupportFragmentManager(), SeeFragment.class, R.id.rlayout_main_phone_container);
    }

    @OnClick({R.id.btn_phone_main_video, R.id.btn_phone_main_audio, R.id.btn_phone_main_profile, R.id.rgroup_main_phone_tab})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_phone_main_video:
                ShowFragmentUtils.addFragment(getSupportFragmentManager(), SeeFragment.class, R.id.rlayout_main_phone_container);
                break;
            case R.id.btn_phone_main_audio:
                ShowFragmentUtils.addFragment(getSupportFragmentManager(), HearFragment.class, R.id.rlayout_main_phone_container);
                break;
            case R.id.btn_phone_main_profile:
                ShowFragmentUtils.addFragment(getSupportFragmentManager(), CacheFragment.class, R.id.rlayout_main_phone_container);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtils.ShowToast("再点一次返回退出");
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
