package com.example.myergedd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.myergedd.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvFh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    private void initView() {
        mIvFh = (ImageView) findViewById(R.id.iv_fh);
        mIvFh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_fh:
                finish();
                break;
        }
    }
}
