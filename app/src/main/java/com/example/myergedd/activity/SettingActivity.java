package com.example.myergedd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myergedd.R;
import com.example.myergedd.base.SimpleActivity;

public class SettingActivity extends SimpleActivity implements View.OnClickListener {

    private ImageView mToolBackImg;
    /**
     * 设置
     */
    private TextView mTopbarTitle;
    private Toolbar mSettingTool;
    private ImageView mLoginImg;
    private RelativeLayout mLogin;
    private ImageView mSettingVipIv;
    private RelativeLayout mSettingVipLayout;
    private RelativeLayout mPayVipLayout;
    private ImageView mVipNoInterfenceIcon;
    private ImageView mVipHdIcon;
    private LinearLayout mSettingVipRightLayout;
    /**
     * 购买会员仅需8元
     */
    private TextView mVipMoneyWarn;
    /**
     * 限时抢购！立享VIP会员特权
     */
    private TextView mVipActivityDetail;
    /**
     * 立即开通
     */
    private TextView mVipAddBtn;
    private RelativeLayout mSettingVipAddLayout;
    private RelativeLayout mPlaySetting;
    private LinearLayout mPlayerSetting;
    private Switch mSettingSoundEnable;
    private LinearLayout mSettingSoundEffect;
    private Switch mSleepToggle;
    /**
     * 06:00
     */
    private TextView mGetUpTimeValue;
    private RelativeLayout mGetUpSetting;
    /**
     * 21:00
     */
    private TextView mSleepTimeValue;
    private RelativeLayout mSleepSetting;
    private LinearLayout mTimeContainer;
    /**  */
    private TextView mRestText;
    private ImageView mRestArrow;
    private RelativeLayout mSettingRest;
    /**  */
    private TextView mVipLimitValue;
    /**
     * 立即开通
     */
    private TextView mVipRenew;
    private RelativeLayout mPhoneSettingRenew;
    private RelativeLayout mPhoneSettingRecord;
    private ImageView mWechatArrow;
    /**
     * 关注微信享福利
     */
    private TextView mWechatSlogan;
    private RelativeLayout mWechat;
    /**
     * 微信公众号
     */
    private TextView mPromotionText;
    private ImageView mPromotionArrow;
    /**
     * egdiandian
     */
    private TextView mPromotionSlogan;
    private RelativeLayout mPromotion;
    private RelativeLayout mPhoneSettingQuestion;
    private RelativeLayout mPhoneSettingFeedback;
    private RelativeLayout mPhoneSettingScore;
    private RelativeLayout mPhoneSettingShare;
    private RelativeLayout mPhoneSettingCooperation;
    private RelativeLayout mPhoneSettingAbout;
    /**
     * 退出登录
     */
    private TextView mLogout;
    /**
     * v2.6.18.debug
     */
    private TextView mTvSettingVersion;
    /**  */
    private TextView mTvSettingPatchVersion;
    private ProgressBar mPbarNetworkErrorLoading;
    private RelativeLayout mProgressLayout;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO:OnCreate Method has been created, run FindViewById again to generate code
        setContentView(R.layout.activity_setting);
        initView();
    }

    public void initView() {
        mToolBackImg = (ImageView) findViewById(R.id.Tool_back_img);
        mToolBackImg.setOnClickListener(this);
        mTopbarTitle = (TextView) findViewById(R.id.topbar_title);
        mSettingTool = (Toolbar) findViewById(R.id.settingTool);
        mLoginImg = (ImageView) findViewById(R.id.login_img);
        mLogin = (RelativeLayout) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mSettingVipIv = (ImageView) findViewById(R.id.setting_vip_iv);
        mSettingVipIv.setOnClickListener(this);
        mSettingVipLayout = (RelativeLayout) findViewById(R.id.setting_vip_layout);
        mSettingVipLayout.setOnClickListener(this);
        mPayVipLayout = (RelativeLayout) findViewById(R.id.pay_vip_layout);
        mPayVipLayout.setOnClickListener(this);
        mVipNoInterfenceIcon = (ImageView) findViewById(R.id.vip_no_interfence_icon);
        mVipNoInterfenceIcon.setOnClickListener(this);
        mVipHdIcon = (ImageView) findViewById(R.id.vip_hd_icon);
        mVipHdIcon.setOnClickListener(this);
        mSettingVipRightLayout = (LinearLayout) findViewById(R.id.setting_vip_right_layout);
        mSettingVipRightLayout.setOnClickListener(this);
        mVipMoneyWarn = (TextView) findViewById(R.id.vip_money_warn);
        mVipMoneyWarn.setOnClickListener(this);
        mVipActivityDetail = (TextView) findViewById(R.id.vip_activity_detail);
        mVipActivityDetail.setOnClickListener(this);
        mVipAddBtn = (TextView) findViewById(R.id.vip_add_btn);
        mVipAddBtn.setOnClickListener(this);
        mSettingVipAddLayout = (RelativeLayout) findViewById(R.id.setting_vip_add_layout);
        mSettingVipAddLayout.setOnClickListener(this);
        mPlaySetting = (RelativeLayout) findViewById(R.id.play_setting);
        mPlaySetting.setOnClickListener(this);
        mPlayerSetting = (LinearLayout) findViewById(R.id.player_setting);
        mPlayerSetting.setOnClickListener(this);
        mSettingSoundEnable = (Switch) findViewById(R.id.setting_sound_enable);
        mSettingSoundEnable.setOnClickListener(this);
        mSettingSoundEffect = (LinearLayout) findViewById(R.id.setting_sound_effect);
        mSettingSoundEffect.setOnClickListener(this);
        mSleepToggle = (Switch) findViewById(R.id.sleep_toggle);
        mSleepToggle.setOnClickListener(this);
        mGetUpTimeValue = (TextView) findViewById(R.id.get_up_time_value);
        mGetUpTimeValue.setOnClickListener(this);
        mGetUpSetting = (RelativeLayout) findViewById(R.id.get_up_setting);
        mGetUpSetting.setOnClickListener(this);
        mSleepTimeValue = (TextView) findViewById(R.id.sleep_time_value);
        mSleepTimeValue.setOnClickListener(this);
        mSleepSetting = (RelativeLayout) findViewById(R.id.sleep_setting);
        mSleepSetting.setOnClickListener(this);
        mTimeContainer = (LinearLayout) findViewById(R.id.time_container);
        mTimeContainer.setOnClickListener(this);
        mRestText = (TextView) findViewById(R.id.rest_text);
        mRestText.setOnClickListener(this);
        mRestArrow = (ImageView) findViewById(R.id.rest_arrow);
        mRestArrow.setOnClickListener(this);
        mSettingRest = (RelativeLayout) findViewById(R.id.setting_rest);
        mSettingRest.setOnClickListener(this);
        mVipLimitValue = (TextView) findViewById(R.id.vip_limit_value);
        mVipLimitValue.setOnClickListener(this);
        mVipRenew = (TextView) findViewById(R.id.vip_renew);
        mVipRenew.setOnClickListener(this);
        mPhoneSettingRenew = (RelativeLayout) findViewById(R.id.phone_setting_renew);
        mPhoneSettingRenew.setOnClickListener(this);
        mPhoneSettingRecord = (RelativeLayout) findViewById(R.id.phone_setting_record);
        mPhoneSettingRecord.setOnClickListener(this);
        mWechatArrow = (ImageView) findViewById(R.id.wechat_arrow);
        mWechatArrow.setOnClickListener(this);
        mWechatSlogan = (TextView) findViewById(R.id.wechat_slogan);
        mWechatSlogan.setOnClickListener(this);
        mWechat = (RelativeLayout) findViewById(R.id.wechat);
        mWechat.setOnClickListener(this);
        mPromotionText = (TextView) findViewById(R.id.promotion_text);
        mPromotionText.setOnClickListener(this);
        mPromotionArrow = (ImageView) findViewById(R.id.promotion_arrow);
        mPromotionArrow.setOnClickListener(this);
        mPromotionSlogan = (TextView) findViewById(R.id.promotion_slogan);
        mPromotionSlogan.setOnClickListener(this);
        mPromotion = (RelativeLayout) findViewById(R.id.promotion);
        mPromotion.setOnClickListener(this);
        mPhoneSettingQuestion = (RelativeLayout) findViewById(R.id.phone_setting_question);
        mPhoneSettingQuestion.setOnClickListener(this);
        mPhoneSettingFeedback = (RelativeLayout) findViewById(R.id.phone_setting_feedback);
        mPhoneSettingFeedback.setOnClickListener(this);
        mPhoneSettingScore = (RelativeLayout) findViewById(R.id.phone_setting_score);
        mPhoneSettingScore.setOnClickListener(this);
        mPhoneSettingShare = (RelativeLayout) findViewById(R.id.phone_setting_share);
        mPhoneSettingShare.setOnClickListener(this);
        mPhoneSettingCooperation = (RelativeLayout) findViewById(R.id.phone_setting_cooperation);
        mPhoneSettingCooperation.setOnClickListener(this);
        mPhoneSettingAbout = (RelativeLayout) findViewById(R.id.phone_setting_about);
        mPhoneSettingAbout.setOnClickListener(this);
        mLogout = (TextView) findViewById(R.id.logout);
        mLogout.setOnClickListener(this);
        mTvSettingVersion = (TextView) findViewById(R.id.tv_setting_version);
        mTvSettingVersion.setOnClickListener(this);
        mTvSettingPatchVersion = (TextView) findViewById(R.id.tv_setting_patch_version);
        mTvSettingPatchVersion.setOnClickListener(this);
        mPbarNetworkErrorLoading = (ProgressBar) findViewById(R.id.pbar_network_error_loading);
        mPbarNetworkErrorLoading.setOnClickListener(this);
        mProgressLayout = (RelativeLayout) findViewById(R.id.progress_layout);
        mProgressLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.Tool_back_img:
                finish();
                break;
            case R.id.login:
                Toast.makeText(this, "签名不对，请检查签名是否与开放平台上填写的一致", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_vip_right_layout:
                startActivity(new Intent(SettingActivity.this, VipActivity.class));
                break;
            case R.id.vip_add_btn:
                startActivity(new Intent(SettingActivity.this, VipActivity.class));
                break;
            case R.id.play_setting:

                break;
            case R.id.setting_sound_enable:
                break;
            case R.id.sleep_toggle:
                break;
            case R.id.time_container:
                break;
            case R.id.rest_text:
                break;
            case R.id.rest_arrow:
                break;
            case R.id.setting_rest:
                break;
            case R.id.vip_limit_value:
                break;
            case R.id.vip_renew:
                break;
            case R.id.phone_setting_renew:
                break;
            case R.id.phone_setting_record:
                break;
            case R.id.wechat_arrow:
                break;
            case R.id.wechat_slogan:
                break;
            case R.id.wechat:
                break;
            case R.id.promotion_text:
                break;
            case R.id.promotion_arrow:
                break;
            case R.id.promotion_slogan:
                break;
            case R.id.promotion:
                break;
            case R.id.phone_setting_question:
                break;
            case R.id.phone_setting_feedback:
                break;
            case R.id.phone_setting_score:
                break;
            case R.id.phone_setting_share:
                break;
            case R.id.phone_setting_cooperation:
                break;
            case R.id.phone_setting_about:
                break;
        }
    }
}
