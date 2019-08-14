package com.example.myergedd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.myergedd.MainActivity;
import com.example.myergedd.R;
import com.example.myergedd.activity.detailshear.DetailsHear;
import com.example.myergedd.activity.detailshear.DetailsHearAdapter;
import com.example.myergedd.activity.detailshear.DetailsHearBean;
import com.example.myergedd.activity.detailshear.DetailsHearPresenter;
import com.example.myergedd.base.BaseActivity;
import com.example.myergedd.base.BasePresenter;
import com.example.myergedd.fragment.hear.erge.ErgeFragment;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailsActivity extends BaseActivity <DetailsHear.DetailsHearView,DetailsHearPresenter<DetailsHear.DetailsHearView>>implements DetailsHear.DetailsHearView {

    private ImageView itemListenTopDetails;
    private ImageView listenTopBackImg;
    /**
     * 标题
     */
    private TextView listenTwoTopTitle;
    private ImageView itemListenTopImg;
    /**
     * 99
     */
    private TextView itemListenCount;
    private RelativeLayout itemListImageContainer;
    /**
     * 专辑标题
     */
    private TextView itemListTitle;
    /**
     * 专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍
     */
    private TextView itemListDesc;
    private ImageView itemListAction;
    private RecyclerView detailRes;
    private ImageView listenPlayerStopImg;
    /**
     * 儿歌点点
     */
    private TextView listenPlayerSongName;
    /**
     * 00:00/00:00
     */
    private TextView listenPlayerPlayTime;
    private ImageView listenPlayerPlayPrev;
    private ImageView listenPlayerPlayNext;
    private ImageView listenPlayerPlayMode;
    private ImageView listenPlayerPlayTimer;
    private ImageView listenPlayerLrc;
    private LinearLayout actionContainer;
    private int id;
    private String name;
    private int count;
    private String url;
    private String description;
    private static final String TAG = "DetailsActivity";
    private DetailsHearAdapter detailsHearAdapter;

    @Override
    protected void initView() {
        id = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");
        count = getIntent().getIntExtra("count",0);
        url = getIntent().getStringExtra("url");
        description = getIntent().getStringExtra("description");
        Log.d(TAG, "onCreate: "+count);
        itemListenTopDetails = (ImageView) findViewById(R.id.item_listen_top_details);
        listenTopBackImg = (ImageView) findViewById(R.id.listen_top_back_img);
        listenTwoTopTitle = (TextView) findViewById(R.id.listen_two_top_title);
        itemListenTopImg = (ImageView) findViewById(R.id.item_listen_top_img);
        itemListenCount = (TextView) findViewById(R.id.item_listen_count);
        itemListImageContainer = (RelativeLayout) findViewById(R.id.item_list_image_container);
        itemListTitle = (TextView) findViewById(R.id.item_list_title);
        itemListDesc = (TextView) findViewById(R.id.item_list_desc);
        itemListAction = (ImageView) findViewById(R.id.item_list_action);
        detailRes = (RecyclerView) findViewById(R.id.detailRes);
        listenPlayerStopImg = (ImageView) findViewById(R.id.listen_player_stop_img);
        listenPlayerSongName = (TextView) findViewById(R.id.listen_player_song_name);
        listenPlayerPlayTime = (TextView) findViewById(R.id.listen_player_play_time);
        listenPlayerPlayPrev = (ImageView) findViewById(R.id.listen_player_play_prev);
        listenPlayerPlayNext = (ImageView) findViewById(R.id.listen_player_play_next);
        listenPlayerPlayMode = (ImageView) findViewById(R.id.listen_player_play_mode);
        listenPlayerPlayTimer = (ImageView) findViewById(R.id.listen_player_play_timer);
        listenPlayerLrc = (ImageView) findViewById(R.id.listen_player_lrc);
        actionContainer = (LinearLayout) findViewById(R.id.action_container);

        Glide.with(this).load(url).into(itemListenTopImg);
        Glide.with(this).load(url)
                .bitmapTransform(new BlurTransformation(this, 100), new CenterCrop(this))
                .into(itemListenTopDetails);
        listenTwoTopTitle.setText(name);
        itemListTitle.setText(name);
        itemListDesc.setText(description);
        itemListenCount.setText(count+"");

        listenTopBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        detailRes.setLayoutManager(new LinearLayoutManager(this));
        detailsHearAdapter = new DetailsHearAdapter(this);
        detailRes.setAdapter(detailsHearAdapter);

    }

    @Override
    public void onSuccessful(DetailsHearBean detailsHearBeans) {
        detailsHearAdapter.setDetailsData(detailsHearBeans);
    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    protected void initData() {
        mPresenter.setDetailsData(338);
    }

    @Override
    protected DetailsHearPresenter<DetailsHear.DetailsHearView> initPresenter() {
        return new DetailsHearPresenter<>();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_details;
    }
}
