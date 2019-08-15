package com.example.myergedd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.myergedd.base.SimpleActivity;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailsActivity extends SimpleActivity implements View.OnClickListener {


    private ImageView mTopBarBackImg;
    /**
     * 标题
     */
    private ImageView mItemListenTopImg;
    /**
     * 专辑标题
     */
    private TextView mItemListTitle;
    /**
     * 专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍专辑介绍
     */
    private TextView mItemListDesc;
    private ImageView mItemListAction;
    private RecyclerView mListenPalyRecy;
    private ProgressBar mListenPlayerProgress;
    private ImageView mListenPlayerStopImg;
    /**
     * 儿歌点点
     */
    private TextView mListenPlayerSongName;
    /**
     * 00:00/00:00
     */
    private TextView mListenPlayerPlayTime;
    private ImageView mListenPlayerPlayPrev;
    private ImageView mListenPlayerPlayNext;
    private ImageView mListenPlayerPlayMode;
    private ImageView mListenPlayerPlayTimer;
    private ImageView mListenPlayerLrc;
    private LinearLayout mActionContainer;
    /**
     * 99
     */
    private TextView mItemListenCount;
    private ImageView mItemListenTopDetails;
    private ImageView mListenTopBackImg;
    /**
     * 标题
     */
    private TextView mListenTwoTopTitle;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_details;
    }

    public void initView() {
        mItemListenTopImg = (ImageView) findViewById(R.id.item_listen_top_img);
        mItemListTitle = (TextView) findViewById(R.id.item_list_title);
        mItemListDesc = (TextView) findViewById(R.id.item_list_desc);
        mItemListAction = (ImageView) findViewById(R.id.item_list_action);
        mListenPalyRecy = (RecyclerView) findViewById(R.id.listen_paly_Recy);
        mListenPlayerProgress = (ProgressBar) findViewById(R.id.listen_player_progress);
        mListenPlayerStopImg = (ImageView) findViewById(R.id.listen_player_stop_img);
        mListenPlayerSongName = (TextView) findViewById(R.id.listen_player_song_name);
        mListenPlayerPlayTime = (TextView) findViewById(R.id.listen_player_play_time);
        mListenPlayerPlayPrev = (ImageView) findViewById(R.id.listen_player_play_prev);
        mListenPlayerPlayNext = (ImageView) findViewById(R.id.listen_player_play_next);
        mListenPlayerPlayMode = (ImageView) findViewById(R.id.listen_player_play_mode);
        mListenPlayerPlayTimer = (ImageView) findViewById(R.id.listen_player_play_timer);
        mListenPlayerLrc = (ImageView) findViewById(R.id.listen_player_lrc);
        mActionContainer = (LinearLayout) findViewById(R.id.action_container);
        mItemListenTopDetails = (ImageView) findViewById(R.id.item_listen_top_details);
        mListenTopBackImg = (ImageView) findViewById(R.id.listen_top_back_img);
        mListenTopBackImg.setOnClickListener(this);
        mListenTwoTopTitle = (TextView) findViewById(R.id.listen_two_top_title);
        mItemListenCount = (TextView) findViewById(R.id.item_listen_count);

        Intent intent = getIntent();
        String title = intent.getStringExtra("name");
        String type = intent.getStringExtra("desc");
        int count = intent.getIntExtra("count", 0);
        String img = intent.getStringExtra("img");

        mItemListTitle.setText(title);
        mListenTwoTopTitle.setText(title);
        mItemListDesc.setText(type);
        mItemListenCount.setText(count + "");
        Glide.with(this).load(img).into(mItemListenTopImg);
        //  Glide.with(this).load(img).into(mItemListenTopDetails);
        Glide.with(this).load(img)
                .bitmapTransform(new BlurTransformation(this, 100), new CenterCrop(this))
                .into(mItemListenTopDetails);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.listen_top_back_img:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_details);
        initView();
    }
}
