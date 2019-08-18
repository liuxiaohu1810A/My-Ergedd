package com.example.myergedd;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.myergedd.utils.Constants;
import com.example.myergedd.utils.RestUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Preferences {
    public static final String PREFERENCES_FILE_USER = "idremao.user";
    public static final String PREFERENCES_FILE_APP = "idremao.app";
    public static final String BANNER_MESSAGE = "BANNER_MESSAGE";//banner的信息
    public static final String LAST_REVIEWED_VERSION_CODE = "LAST_REVIEWED_VERSION_CODE";//上次去评论的version_code
    public static final String LAST_REVIEWED_TIMESTAMP = "LAST_REVIEWED_TIMESTAMP";//上次去评论的时间
    public static final String LOCAL_SEARCH_HISTORY = "LOCAL_SEARCH_HISTORY";//本地视频播放纪录
    public static final String LOCAL_AUDIO_SEARCH_HISTORY = "LOCAL_AUDIO_SEARCH_HISTORY";//本地音频的播放记录
    public static final String SPlASH_ADVERTISEMENT_IMAGE_URL = "SPlASH_ADVERTISEMENT_IMAGE_URL";//splashActivity广告页图片
    public static final String REFERERKEY = "REFERERKEY";
    public static final String USE_FIRST_TIME = "USE_FIRST_TIME";
    public static final String PROMPT_FAVOURITE = "PROMPT_FAVOURITE";
    public static final String LAST_USING_MAIN_TAB = "LAST_USING_MAIN_TAB";
    public static final String LAST_SELECT_CACHE_TAB = "last_select_cache_tab";
    public static final String SET_KID_AGE_LEVEL = "SET_KID_AGE_LEVEL";
    private static final String WIFI_ONLY = "WIFI_ONLY";
    private static final String SHOW_REDPOINT = "SHOW_REDPOINT";
    private static final String UUID = "UUID";
    private static final String CACHE_CONTROL = "CACHE_CONTROL";
    //    private static final String MUSIC_CONTROL="MUSIC_CONTROL";
    private static final String VIDEO_PLAY_MODE_OPTION = "VIDEO_PLAY_MODE_OPTION";
    private static final String VIDEO_PLAY_CONTROL_STRATEGY = "VIDEO_PLAY_CONTROL_STRATEGY";
    private static final String VIDEO_CONTROL_COUNT_LONG = "VIDEO_CONTROL_COUNT_LONG";
    private static final String VIDEO_CONTROL_REMAIN_COUNT_LONG = "VIDEO_CONTROL_REMAIN_COUNT_LONG";
    private static final String VIDEO_CONTROL_TIME_LONG = "VIDEO_CONTROL_TIME_LONG";
    private static final String VIDEO_CONTROL_REMAIN_TIME_LONG = "VIDEO_CONTROL_REMAIN_TIME_LONG";
    private static final String VIDEO_CONTROL_RESET_TIME = "VIDEO_CONTROL_RESET_TIME";
    private static final String AUDIO_PLAY_MODE_OPTION = "AUDIO_PLAY_MODE_OPTION";

    private static final String AUDIO_PLAY_CONTROL_STRATEGY = "AUDIO_PLAY_CONTROL_STRATEGY";
    private static final String AUDIO_CONTROL_COUNT_LONG = "AUDIO_CONTROL_COUNT_LONG";
    private static final String AUDIO_CONTROL_TIME_LONG = "AUDIO_CONTROL_TIME_LONG";

    private static final String AD_CLICK_TIME_SPAN = "AD_CLICK_TIME_SPAN";
    private static final String AD_START_SECONDS = "AD_START_SECONDS";
    private static final String AD_SHOWN_AFTER_VIDEO_COUNT = "AD_SHOWN_AFTER_VIDEO_COUNT";
    private static final String SENSITIVE_LIMIT_COUNT = "SENSITIVE_LIMIT_COUNT";

    //特殊投放规则存储
    private static final String RULE_CONTENT = "RULE_CONTENT";
    // 解锁特殊投放规则
    private static final String UNLOCK_RULE_CONTENT = "UNLOCK_RULE_CONTENT";

    private static final String ENABLE_IQIYI = "ENABLE_IQIYI";

    private static final String SLEEP_CONTROL = "SLEEP_CONTROL";
    private static final String SLEEP_TIME = "SLEEP_TIME";
    private static final String GETUP_TIME = "GETUP_TIME";
    private static final String REST_DURATION = "REST_DURATION";

    private static final String LAST_SLEEP_CHECK = "LAST_SLEEP_CHECK";
    private static final String LAST_TIME_OUT_CHECK = "LAST_TIME_OUT_CHECK";

    private static final String LOCAL_AUDIO_PLAY_COUNT = "LOCAL_AUDIO_PLAY_COUNT";
    private static final String LOCAL_VIDEO_PLAY_COUNT = "LOCAL_VIDEO_PLAY_COUNT";
    private static final String REVIEW_STAUTS = "REVIEW_STAUTS";

    private static final String PLAY_REPORT = "PLAY_REPORT";
    private static final String PLAY_REPORT_AUDIO = "PLAY_REPORT_AUDIO";

    private static final String IQIYI_ACCESSTOKEN = "IQIYI_ACCESSTOKEN";

    private static final String DEVICE = "DEVICE";
    private static final String DEVICE_UPDATE_TIME = "DEVICE_UPDATE_TIME";

    private static final String DOWNLOAD_TO_SDCARD = "DOWNLOAD_TO_SDCARD";
    private static final String FORCE_PLAYER = "FORCE_PLAYER";

    private static final String IMAGE_SCHEMA = "IMAGE_SCHEMA";

    private static final String HOT_FIX = "HOT_FIX";
    private static final String EVENT = "EVENT";

    private static final String ENABLE_SPLASH_SOUND = "ENABLE_SPLASH_SOUND";
    private static final String INSTALL_VERSION = "INSTALL_VERSION";
    private static final String NEW_USER = "NEW_USER";
    private static final String CURRENT_THEME = "CURRENT_THEME";
    private static final String CURRENT_QUALITY = "CURRENT_QUALITY";
    private static final String FIRST_CHANNEL = "FIRST_CHANNEL";

    private static final String AUDIO_PLAYER_STATE = "AUDIO_PLAYER_STATE";
    public static final String USER = "USER";
    private static final String LATEST_LOGIN = "LATEST_LOGIN";
    private static final String GDT_SHOW_LIMIT = "GDT_SHOW_LIMIT";
    private static final String MAGNET_STAT = "MAGNET_STAT";

    private static final String LATEST_VIDEO = "LATEST_VIDEO";

    private static final String KEY_LAST_GO_BACKGROUND_TIME = "key_last_go_background_time";

    // 只为测试 儿歌点点
    private static final String KEY_ERGEDD_TEST = "key_ergedd_test";
    // 只为测试 萌宝儿歌大全
    private static final String KEY_BBVIDEO_TEST = "key_bbvideo_test";
    // 只为测试 banner配置 儿歌点点
    private static final String KEY_ERGEDD_BANNER_TEST = "key_ergedd_banner_test";
    // 只为测试 banner配置 萌宝儿歌大全
    private static final String KEY_BBVIDEO_BANNER_TEST = "key_bbvideo_banner_test";

    //视频清晰度
    private static final String KEY_VIDEO_SOURCE = "video_source";


    //萌宝儿歌大全AB测试（host）
    private static final String KEY_BBVIDEO_HOST_TEST = "key_bbvideo_host_test";

    private static Preferences sPreferences;
    private final SharedPreferences mUserSharedPreferences;
    private final SharedPreferences mAppSharedPreferences;

    private Preferences(Context context) {
        mUserSharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_USER, Context.MODE_PRIVATE);
        mAppSharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_APP, Context.MODE_PRIVATE);
    }

    public static synchronized Preferences getPreferences(Context context) {
        if (sPreferences == null) {
            sPreferences = new Preferences(context);
        }
        return sPreferences;
    }

    public boolean getWifiOnly() {
        return mUserSharedPreferences.getBoolean(WIFI_ONLY, true);
    }

    public void setWifiOnly(boolean downloadOnWifiOnly) {
        mUserSharedPreferences.edit().putBoolean(WIFI_ONLY, downloadOnWifiOnly).apply();
    }

    /**
     * 赋值视频清晰度码流
     *
     * @param source
     */
    public void setVideoSource(String source) {
        mUserSharedPreferences.edit().putString(KEY_VIDEO_SOURCE, source).apply();
    }

    /**
     * 获取视频码流
     *
     * @return
     */
    public String getVideoSource() {
        return mUserSharedPreferences.getString(KEY_VIDEO_SOURCE, "hd");
    }

    public boolean isShowRedPoint() {
        return mUserSharedPreferences.getBoolean(SHOW_REDPOINT, false);
    }

    public void setShowRedpoint(Boolean showRedpoint) {
        mUserSharedPreferences.edit().putBoolean(SHOW_REDPOINT, showRedpoint).apply();
    }

    public String getUUID() {
        return mAppSharedPreferences.getString(UUID, null);
    }

    public void setUUID(String uuid) {
        mAppSharedPreferences.edit().putString(UUID, uuid).apply();
    }

    public String getBannerMessage() {
        return mUserSharedPreferences.getString(BANNER_MESSAGE, null);//mark not request
    }

    public void setBannerMessage(String message) {
        mUserSharedPreferences.edit().putString(BANNER_MESSAGE, message).apply();
    }

    public int getLastReviewedVersionCode() {
        return mUserSharedPreferences.getInt(LAST_REVIEWED_VERSION_CODE, 0);
    }

    public void setLastReviewedVersionCode(int verionCode) {
        mUserSharedPreferences.edit().putInt(LAST_REVIEWED_VERSION_CODE, verionCode).apply();
    }

    public Long getLastReviewedTimeStamp() {
        return mUserSharedPreferences.getLong(LAST_REVIEWED_TIMESTAMP, Constants.REVIEW_STATUS_NEW_INSTALL); // mark as a new build
    }

    public void setLastReviewedTimeStamp(Long time) {
        mUserSharedPreferences.edit().putLong(LAST_REVIEWED_TIMESTAMP, time).apply();
    }

    public String getLocalVideoSearchHistory() {
        return mUserSharedPreferences.getString(LOCAL_SEARCH_HISTORY, null);
    }

    public void setLocalVideoSearchHistory(String localSearchHistory) {
        mUserSharedPreferences.edit().putString(LOCAL_SEARCH_HISTORY, localSearchHistory).apply();
    }

    public String getLocalAudioSearchHistory() {
        return mUserSharedPreferences.getString(LOCAL_AUDIO_SEARCH_HISTORY, null);
    }

    public void setLocalAudioSearchHistory(String localSearchHistory) {
        mUserSharedPreferences.edit().putString(LOCAL_AUDIO_SEARCH_HISTORY, localSearchHistory).apply();
    }

    public String getSplashActivityImageUrl() {
        return mUserSharedPreferences.getString(SPlASH_ADVERTISEMENT_IMAGE_URL, "");
    }

    public void setSplashActivityImageUrl(String imageUrl) {
        mUserSharedPreferences.edit().putString(SPlASH_ADVERTISEMENT_IMAGE_URL, imageUrl).apply();
    }

    public String getRefererkey() {
        return mUserSharedPreferences.getString(REFERERKEY, Constants.DEFAULT_REFERER_KEY);
    }

    public void setRefererkey(String string) {
        mUserSharedPreferences.edit().putString(REFERERKEY, string).apply();
    }

    public void setUseFirstTime(long useFirstTime) {
        mUserSharedPreferences.edit().putLong(USE_FIRST_TIME, useFirstTime).apply();
    }

    public long getUserFirstTime() {
        return mUserSharedPreferences.getLong(USE_FIRST_TIME, -1);//-1 default
    }


    public int getPromptFavourite() {
        return mUserSharedPreferences.getInt(PROMPT_FAVOURITE, 3); //3 default
    }

    public void setPromptFavourite(int counts) {
        mUserSharedPreferences.edit().putInt(PROMPT_FAVOURITE, counts).apply();
    }

    public boolean getCacheControl() {
        return mUserSharedPreferences.getBoolean(CACHE_CONTROL, true);//default true
    }

    public void setCacheControl(boolean cacheControl) {
        mUserSharedPreferences.edit().putBoolean(CACHE_CONTROL, cacheControl).apply();
    }

    public int getVideoPlayModeOption() {
        return mUserSharedPreferences.getInt(VIDEO_PLAY_MODE_OPTION, Constants.MODE_OPTION_ORDER);
    }

    public void setVideoPlayModeOption(int modeOption) {
        mUserSharedPreferences.edit().putInt(VIDEO_PLAY_MODE_OPTION, modeOption).apply();
    }

    public int getPlayControlStrategy() {
        return mUserSharedPreferences.getInt(VIDEO_PLAY_CONTROL_STRATEGY, Constants.PLAY_STRATEGY_NONE);
    }

    public void setPlayControlStrategy(int playControlStrategy) {
        mUserSharedPreferences.edit().putInt(VIDEO_PLAY_CONTROL_STRATEGY, playControlStrategy).apply();
    }


    public long getVideoControlTime() {
        return mUserSharedPreferences.getLong(VIDEO_CONTROL_TIME_LONG, Constants.TIME_LIMIT_45);
    }

    public void setVideoControlTime(long videoControlTime) {
        mUserSharedPreferences.edit().putLong(VIDEO_CONTROL_TIME_LONG, videoControlTime).apply();
    }

    public long getVideoControlCount() {
        return mUserSharedPreferences.getLong(VIDEO_CONTROL_COUNT_LONG, Constants.COUNT_LIMIT_10);
    }

    public void setVideoControlCount(long videoControlCount) {
        mUserSharedPreferences.edit().putLong(VIDEO_CONTROL_COUNT_LONG, videoControlCount).apply();
    }

    public long getVideoControlRemainCount() {
        return mUserSharedPreferences.getLong(VIDEO_CONTROL_REMAIN_COUNT_LONG, Constants.COUNT_LIMIT_10);
    }

    public void setVideoControlRemainCount(long videoControlCount) {
        mUserSharedPreferences.edit().putLong(VIDEO_CONTROL_REMAIN_COUNT_LONG, videoControlCount).apply();
    }


    public long getVideoControlRemainTime() {
        return mUserSharedPreferences.getLong(VIDEO_CONTROL_REMAIN_TIME_LONG, Constants.TIME_LIMIT_60);
    }

    public void setVideoControlRemainTime(long videoControlTime) {
        mUserSharedPreferences.edit().putLong(VIDEO_CONTROL_REMAIN_TIME_LONG, videoControlTime).apply();
    }

    public long getVideoControlResetTime() {
        return mUserSharedPreferences.getLong(VIDEO_CONTROL_RESET_TIME, -1L);
    }

    public void setVideoControlResetTime(long resetTime) {
        mUserSharedPreferences.edit().putLong(VIDEO_CONTROL_RESET_TIME, resetTime).apply();
    }

    public int getAudioPlayModeOption() {
        return mUserSharedPreferences.getInt(AUDIO_PLAY_MODE_OPTION, Constants.MODE_OPTION_ORDER);
    }

    /*public void setAudioPlayModeOption(@PlayModeFlavour int audioPlayModeOption) {
        mUserSharedPreferences.edit().putInt(AUDIO_PLAY_MODE_OPTION, audioPlayModeOption).apply();
    }*/

//    public boolean getMusicControl(){
//        return mUserSharedPreferences.getBoolean(MUSIC_CONTROL,false);
//    }
//
//    public void setMusicControl(boolean musicControl) {
//        mUserSharedPreferences.edit().putBoolean(MUSIC_CONTROL, musicControl).apply();
//    }

    public int getLastUsingTab() {
        return mUserSharedPreferences.getInt(LAST_USING_MAIN_TAB, Constants.TAB_VIDEO); //3 default
    }

    public void setLastUsingTab(int tabIndex) {
        mUserSharedPreferences.edit().putInt(LAST_USING_MAIN_TAB, tabIndex).apply();
    }

    public int getLastSelectCacheTab() {
        return mUserSharedPreferences.getInt(LAST_SELECT_CACHE_TAB, Constants.TAB_CACHE_VIDEO);
    }

    public void setLastSelectCacheTab(int tabIndex) {
        mUserSharedPreferences.edit().putInt(LAST_SELECT_CACHE_TAB, tabIndex).apply();
    }

    public int getKidAgeLevel() {
        return mUserSharedPreferences.getInt(SET_KID_AGE_LEVEL, Constants.KIDS_AGE_LEVVEL_NONE);
    }

    public void setKidAgeLevel(int ageLevel) {
        mUserSharedPreferences.edit().putInt(SET_KID_AGE_LEVEL, ageLevel).apply();
    }

    public boolean getEnableIqiyi() {
        return mUserSharedPreferences.getBoolean(ENABLE_IQIYI, true);
    }

    public void setEnableIqiyi(Boolean enable) {
        mUserSharedPreferences.edit().putBoolean(ENABLE_IQIYI, enable).apply();
    }

    public long getRestTime() {
        return mUserSharedPreferences.getLong(REST_DURATION, 0);
    }

    public void setRestTime(long restDuration) {
        mUserSharedPreferences.edit().putLong(REST_DURATION, restDuration).apply();
    }

    public boolean getSleepControl() {
        return mUserSharedPreferences.getBoolean(SLEEP_CONTROL, false);
    }

    public void setSleepControl(boolean downloadOnWifiOnly) {
        mUserSharedPreferences.edit().putBoolean(SLEEP_CONTROL, downloadOnWifiOnly).apply();
    }

    public long getSleepTime() {
        return mUserSharedPreferences.getLong(SLEEP_TIME, Constants.HOUR_TIME * 21);
    }

    public void setSleepTime(long sleepTime) {
        mUserSharedPreferences.edit().putLong(SLEEP_TIME, sleepTime).apply();
    }


    public long getGetUpTime() {
        return mUserSharedPreferences.getLong(GETUP_TIME, Constants.HOUR_TIME * 6);
    }

    public void setGetUpTime(long getup) {
        mUserSharedPreferences.edit().putLong(GETUP_TIME, getup).apply();
    }

    public long getLastSleepCheckTime() {
        return mUserSharedPreferences.getLong(LAST_SLEEP_CHECK, -1);
    }

    public void setLastSleepCheckTime(long time) {
        mUserSharedPreferences.edit().putLong(LAST_SLEEP_CHECK, time).apply();
    }

    public long getLastTimeOutCheck() {
        return mUserSharedPreferences.getLong(LAST_TIME_OUT_CHECK, -1L);
    }

    public void setLastTimeOutCheck(long time) {
        mUserSharedPreferences.edit().putLong(LAST_TIME_OUT_CHECK, time).apply();
    }

    public long getLocalVideoPlayCount() {
        return mUserSharedPreferences.getLong(LOCAL_VIDEO_PLAY_COUNT, 01L);
    }

    public void setLocalVideoPlayCount(long count) {
        mUserSharedPreferences.edit().putLong(LOCAL_VIDEO_PLAY_COUNT, count).apply();
    }

    public long getLocalAudioPlayCount() {
        return mUserSharedPreferences.getLong(LOCAL_AUDIO_PLAY_COUNT, 01L);
    }

    public void setLocalAudioPlayCount(long count) {
        mUserSharedPreferences.edit().putLong(LOCAL_AUDIO_PLAY_COUNT, count).apply();
    }


    public boolean getReviewStatus() {
        return mUserSharedPreferences.getBoolean(REVIEW_STAUTS, false);
    }

    public void setReviewStatus(boolean reviewed) {
        mUserSharedPreferences.edit().putBoolean(REVIEW_STAUTS, reviewed).apply();
    }


    public int getAudioPlayControlStrategy() {
        return mUserSharedPreferences.getInt(AUDIO_PLAY_CONTROL_STRATEGY, Constants.PLAY_STRATEGY_NONE);
    }

    public void setAudioPlayControlStrategy(int playControlStrategy) {
        mUserSharedPreferences.edit().putInt(AUDIO_PLAY_CONTROL_STRATEGY, playControlStrategy).apply();
    }

    public long getAudioControlTime() {
        return mUserSharedPreferences.getLong(AUDIO_CONTROL_TIME_LONG, Constants.TIME_LIMIT_60);
    }

    public void setAudioControlTime(long audioControlTime) {
        mUserSharedPreferences.edit().putLong(AUDIO_CONTROL_TIME_LONG, audioControlTime).apply();
    }

    public long getAudioControlCount() {
        return mUserSharedPreferences.getLong(AUDIO_CONTROL_COUNT_LONG, Constants.COUNT_LIMIT_20);
    }

    public void setAudioControlCount(long audioControlCount) {
        mUserSharedPreferences.edit().putLong(AUDIO_CONTROL_COUNT_LONG, audioControlCount).apply();
    }

    // 获取百度横幅广告点击间隔
    public long getAdClickSpan() {
        return mUserSharedPreferences.getLong(AD_CLICK_TIME_SPAN, Constants.AD_TIME_SPAN);
    }

    // 设置百度横幅广告点击间隔
    public void setAdClickSpan(long timeSpan) {
        mUserSharedPreferences.edit().putLong(AD_CLICK_TIME_SPAN, timeSpan).apply();
    }

    // 获取百度横幅广告最低播放数量
    public long getAdShowVideoCount() {
        return mUserSharedPreferences.getLong(AD_SHOWN_AFTER_VIDEO_COUNT, Constants.VIDEO_ADVERTISEMENT_LIMIT_DEFAULT);
    }

    // 设置百度横幅广告最低播放数量
    public void setAdShowVideoCount(long videoCount) {
        mUserSharedPreferences.edit().putLong(AD_SHOWN_AFTER_VIDEO_COUNT, videoCount).apply();
    }

    // 获取百度横幅广告展示视频播放开始秒数
    public long getAdStartSeconds() {
        return mUserSharedPreferences.getLong(AD_START_SECONDS, Constants.VIDEO_AD_START_SECONDS_DEFAULT);
    }

    // 设置百度横幅广告展示视频播放开始秒数
    public void setAdStartSeconds(long seconds) {
        mUserSharedPreferences.edit().putLong(AD_START_SECONDS, seconds).apply();
    }

    // 获取版权限制数
    public long getSensitiveLimit() {
        return mUserSharedPreferences.getLong(SENSITIVE_LIMIT_COUNT, 0);
    }

    // 设置版权限制数
    public void setSensitiveLimit(long counts) {
        mUserSharedPreferences.edit().putLong(SENSITIVE_LIMIT_COUNT, counts).apply();
    }

  /*  *//**
     * 存储规则
     *
     * @param rules
     *//*
    public void setRules(List<RuleBean> rules) {
        try {
            RulesFilter.getInstance().setBeans(rules);
            mUserSharedPreferences.edit().putString(RULE_CONTENT, JSONUtil.toJSON(rules)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    *//**
     * 赋值操作
     *//*
    public void getRules() {
        try {
            String json = mUserSharedPreferences.getString(RULE_CONTENT, null);
            if (!TextUtils.isEmpty(json)) {
                RulesFilter.getInstance().convert(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    *//**
     * bbvideo modify version: 6.2.06
     * 存储被解锁规则
     *
     * @param states
     *//*
    public void setUnlockRules(Map<String, Boolean> states) {
        try {
            RulesFilter.getInstance().setStates(states);
            String content = JSONUtil.toJSON(states);
            mUserSharedPreferences.edit().putString(UNLOCK_RULE_CONTENT, content).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    *//**
     * bbvideo added version: 6.2.06
     * 根据规则id获取解锁状态  true 已解锁   false  未解锁
     *//*
    public boolean getUnlockRulesStatus(String ruleId) {
        boolean bRet = false;
        try {
            String json = mUserSharedPreferences.getString(UNLOCK_RULE_CONTENT, null);
            if (!TextUtils.isEmpty(json)) {
                RulesFilter.getInstance().convertStates(json);
            }

            Map<String, Boolean> states = RulesFilter.getInstance().getStates();

            if (null != states && states.containsKey(ruleId)) {
                bRet = states.get(ruleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bRet;
    }

    *//**
     * 标记特殊规则Id授权状态
     *
     * @param id
     *//*
    public void setRuleIdInfo(String id) {
        mUserSharedPreferences.edit().putBoolean(id, true);
    }

    *//**
     * 标记特殊规则Id是否已授权
     *
     * @param id
     *//*
    public boolean isCompleteForRule(String id) {
        return mUserSharedPreferences.getBoolean(id, false);
    }

    public String getImageSchema() {
        return mUserSharedPreferences.getString(IMAGE_SCHEMA, "");
    }

    public void setImageSchema(String json) {
        mUserSharedPreferences.edit().putString(IMAGE_SCHEMA, json).apply();
    }


    public void addPlayReport(PlayReport report) {
        try {
            RestUtil.getInstance().addDuration(1000L * (report.getEnd_time() - report.getStart_time()));
            ArrayList<PlayReport> arrays = getPlayReport();
            if (!arrays.contains(report))
                arrays.add(report);
            String reportString = JSONUtil.toJSON(arrays);
            mUserSharedPreferences.edit().putString(PLAY_REPORT, reportString).apply();
            //统计上报
            StaticsEventUtil.statisAVInfo(report);
        } catch (OutOfMemoryError er) {
            clearPlayReport();
        } catch (Exception ex) {
            clearPlayReport();
        }
    }

    *//**
     * 统计广告
     *
     * @param report
     *//*
    public void addADPlayReport(PlayReport report, StatisBusiness.Event k) {
        try {
            RestUtil.getInstance().addDuration(1000L * (report.getEnd_time() - report.getStart_time()));
            ArrayList<PlayReport> arrays = getPlayReport();
            if (!arrays.contains(report))
                arrays.add(report);
            String reportString = JSONUtil.toJSON(arrays);
            mUserSharedPreferences.edit().putString(PLAY_REPORT, reportString).apply();
            //统计上报
            StaticsEventUtil.statisADInfo(report, k);
        } catch (OutOfMemoryError er) {
            clearPlayReport();
        } catch (Exception ex) {
            clearPlayReport();
        }
    }

    public ArrayList<PlayReport> getPlayReport() {
        try {
            String reportString = mUserSharedPreferences.getString(PLAY_REPORT, "");
            if (reportString.length() < 500000) {
                PlayReport[] reports = JSONUtil.toObject(reportString, PlayReport[].class);
                ArrayList<PlayReport> arrays = new ArrayList<>();
                if (reports != null) {
                    arrays.addAll(Arrays.asList(reports));
                }
                return arrays;
            } else {
                clearPlayReport();
                return new ArrayList<>();
            }
        } catch (OutOfMemoryError ex) {
            clearPlayReport();
            return new ArrayList<>();
        } catch (Exception ex) {
            clearPlayReport();
            return new ArrayList<>();
        }
    }

    public void clearPlayReport() {
        mUserSharedPreferences.edit().putString(PLAY_REPORT, "").commit();
    }

    public void addPlayReportAudio(PlayReportAudio report) {
        try {
            ArrayList<PlayReportAudio> arrays = getPlayReportAudio();
            if (!arrays.contains(report))
                arrays.add(report);
            String reportString = JSONUtil.toJSON(arrays);
            mUserSharedPreferences.edit().putString(PLAY_REPORT_AUDIO, reportString).apply();

            //统计上报
            StaticsEventUtil.statisAVInfo(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PlayReportAudio> getPlayReportAudio() {
        String reportString = mUserSharedPreferences.getString(PLAY_REPORT_AUDIO, "");
        PlayReportAudio[] reports = JSONUtil.toObject(reportString, PlayReportAudio[].class);
        ArrayList<PlayReportAudio> arrays = new ArrayList<>();
        if (reports != null) {
            arrays.addAll(Arrays.asList(reports));
        }
        return arrays;
    }

    public void clearPlayReportAudio() {
        mUserSharedPreferences.edit().putString(PLAY_REPORT_AUDIO, "").apply();
    }

    public void saveDevice(String device) {
        mUserSharedPreferences.edit().putString(DEVICE, device).apply();
    }

    public String getDevice() {
        return mUserSharedPreferences.getString(DEVICE, "");
    }

    public void saveDeviceUpdateTime(long time) {
        mUserSharedPreferences.edit().putLong(DEVICE_UPDATE_TIME, time).apply();
    }

    public long getDeviceUpdateTime() {
        return mUserSharedPreferences.getLong(DEVICE_UPDATE_TIME, 0);
    }

    //####################################################
    public void clear() {
        mUserSharedPreferences.edit().clear().apply();
    }

    public boolean isDownloadToSdcard() {
        return mUserSharedPreferences.getBoolean(DOWNLOAD_TO_SDCARD, false);
    }

    public void setDownloadToSdcard(boolean flag) {
        mUserSharedPreferences.edit().putBoolean(DOWNLOAD_TO_SDCARD, flag).apply();
    }

    public boolean isEnableSplashSound() {
        return mUserSharedPreferences.getBoolean(ENABLE_SPLASH_SOUND, true);
    }

    public void setEnableSplashSound(boolean flag) {
        mUserSharedPreferences.edit().putBoolean(ENABLE_SPLASH_SOUND, flag).apply();
    }

    public boolean isForceUseOriginalPlayer() {
        return VideoPlayerStrategy.Player.ORIGINAL.name().equals(mUserSharedPreferences.getString(FORCE_PLAYER, VideoPlayerStrategy.Player.EXO.name()));
    }

    public void setForceUseOriginalPlayer(String player) {
        mUserSharedPreferences.edit().putString(FORCE_PLAYER, player).apply();
    }

    public void saveIqiyiAccessToken(String accessToken) {
        mUserSharedPreferences.edit().putString(IQIYI_ACCESSTOKEN, accessToken).apply();
    }

    public String getIqiyiAccessToken() {
        return mUserSharedPreferences.getString(IQIYI_ACCESSTOKEN, "");
    }

    public void savePatchId(String patchId) {
        mUserSharedPreferences.edit().putString(HOT_FIX, patchId).commit();
    }

    public String getInstallPatchId() {
        return mUserSharedPreferences.getString(HOT_FIX, "");
    }


    public void addEvent(LocalTrackUtil.Event event) {
        try {
            ArrayList<LocalTrackUtil.Event> arrays = getEvents();
            arrays.add(event);
            String records = JSONUtil.toJSON(arrays);
            mUserSharedPreferences.edit().putString(EVENT, records).commit();
        } catch (OutOfMemoryError er) {
            clearEvents();
        } catch (Exception ex) {
            clearEvents();
        }
    }

    public ArrayList<LocalTrackUtil.Event> getEvents() {
        String reportString = mUserSharedPreferences.getString(EVENT, "");
        LocalTrackUtil.Event[] reports = JSONUtil.toObject(reportString, LocalTrackUtil.Event[].class);
        ArrayList<LocalTrackUtil.Event> arrays = new ArrayList<>();
        if (reports != null) {
            arrays.addAll(Arrays.asList(reports));
        }
        return arrays;
    }

    public void clearEvents() {
        mUserSharedPreferences.edit().putString(EVENT, "").commit();
    }


    public void save(String key, String value) {
        mUserSharedPreferences.edit().putString(key, value).apply();
    }

    public String get(String key) {
        return mUserSharedPreferences.getString(key, "");
    }

    public String getInstallVersion() {
        return mUserSharedPreferences.getString(INSTALL_VERSION, "");
    }

    public void setInstallVersion(String version) {
        mUserSharedPreferences.edit().putString(INSTALL_VERSION, version).apply();
    }

    *//**
     * 1 for new user
     * -1 for old user
     * 0 for undefine
     *
     * @return
     *//*
    public int getNewUser() {
        return mUserSharedPreferences.getInt(NEW_USER, 0);
    }

    public void setNewUser(int isNewUser) {
        mUserSharedPreferences.edit().putInt(NEW_USER, isNewUser).apply();
    }

    public boolean hasPrivilege(String key) {
        return mUserSharedPreferences.getBoolean(key, false);
    }

    public void setPrivilege(String key, boolean value) {
        mUserSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void setSelectedTheme(String theme) {
        mUserSharedPreferences.edit().putString(CURRENT_THEME, theme).apply();
    }

    public String getSelectedTheme() {
        return mUserSharedPreferences.getString(CURRENT_THEME, PrivilegeUtil.KEY_DEFAULT);
    }

    public void setQuality(String quality) {
        mUserSharedPreferences.edit().putString(CURRENT_QUALITY, quality).commit();
    }

    public String getQuality() {
        return mUserSharedPreferences.getString(CURRENT_QUALITY, Quality.HD);
    }

    public String getFirstChannel() {
        String firstChannel = mUserSharedPreferences.getString(FIRST_CHANNEL, "undefine");
        if ("undefine".equals(firstChannel)) {
            firstChannel = ChannelUtil.getChannel();
            mUserSharedPreferences.edit().putString(FIRST_CHANNEL, firstChannel).commit();
        }
        return firstChannel;
    }

    public void saveAudioPlayerState(String audioPlayerState) {
        mUserSharedPreferences.edit().putString(AUDIO_PLAYER_STATE, audioPlayerState).apply();
    }

    public String getAudioPlayerState() {
        return mUserSharedPreferences.getString(AUDIO_PLAYER_STATE, "");
    }

    public void saveUser(String user) {
        mUserSharedPreferences.edit().putString(USER, user).apply();
    }

    public String getUser() {
        return mUserSharedPreferences.getString(USER, "");
    }


    public void saveLatestLoginChannel(String channel) {
        mUserSharedPreferences.edit().putString(LATEST_LOGIN, channel).apply();
    }

    public String getLatestLoginChannel() {
        return mUserSharedPreferences.getString(LATEST_LOGIN, "");
    }

    // 获取广点通每日最大显示次数
    public int getGDTLimit() {
        return mUserSharedPreferences.getInt(GDT_SHOW_LIMIT, 13);
    }

    // 设置广点通每日最大显示次数
    public void setGDTLimit(int gdtLimit) {
        mUserSharedPreferences.edit().putInt(GDT_SHOW_LIMIT, gdtLimit).apply();
    }

    public void addOrUpdateMagnetStat(MagnetStat magnetStat) {
        try {
            ArrayList<MagnetStat> arrays = getMagnetStat();
            if (!arrays.contains(magnetStat)) {
                arrays.add(magnetStat);
            } else {
                for (int i = 0; i < arrays.size(); i++) {
                    if (arrays.get(i).equals(magnetStat)) {
                        arrays.get(i).setView(magnetStat.getView() + arrays.get(i).getView());
                        arrays.get(i).setClick(magnetStat.getClick() + arrays.get(i).getClick());
                    }
                }
            }
            String reportString = JSONUtil.toJSON(arrays);
            mUserSharedPreferences.edit().putString(MAGNET_STAT, reportString).commit();
        } catch (OutOfMemoryError er) {
            clearMagnetStat();
        } catch (Exception ex) {
            clearMagnetStat();
        }
    }

    public ArrayList<MagnetStat> getMagnetStat() {
        String reportString = mUserSharedPreferences.getString(MAGNET_STAT, "");
        MagnetStat[] reports = JSONUtil.toObject(reportString, MagnetStat[].class);
        ArrayList<MagnetStat> arrays = new ArrayList<>();
        if (reports != null) {
            arrays.addAll(Arrays.asList(reports));
        }
        return arrays;
    }

    public void clearMagnetStat() {
        mUserSharedPreferences.edit().putString(MAGNET_STAT, "").commit();
    }

    // 获取最后视频播放Model
    public VideoModel getLatestVideo() {
        VideoModel videoModel = null;
        try {
            String jsonString = mUserSharedPreferences.getString(LATEST_VIDEO, "");
            if (!TextUtils.isEmpty(jsonString))
                videoModel = JSONUtil.toObject(jsonString, VideoModel.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return videoModel;
    }

    // 保存最后视频播放Model
    public void saveLatestVideo(VideoModel videoModel) {
        mUserSharedPreferences.edit().putString(LATEST_VIDEO, JSONUtil.toJSON(videoModel)).commit();
    }

    *//**
     * 设置进入后台的时间
     *
     * @param timeMillis ms
     *//*
    public void setLastGoBackgroundTime(long timeMillis) {
        mUserSharedPreferences.edit().putLong(KEY_LAST_GO_BACKGROUND_TIME, timeMillis).apply();
    }

    public long getLastGoBackgroundTime() {
        return mUserSharedPreferences.getLong(KEY_LAST_GO_BACKGROUND_TIME, 0L);
    }

    // 保存萌宝儿歌大全 配置信息  测试专用
    public void saveBbvideoObject(String strObject) {
        mUserSharedPreferences.edit().putString(KEY_BBVIDEO_TEST, strObject).apply();
    }

    // 获取萌宝儿歌大全 配置信息  测试专用
    public String getBbVideoObject() {
        return mUserSharedPreferences.getString(KEY_BBVIDEO_TEST, "");
    }

    private BabyTestConfig getBabyTestConfig() {
        String configStr = getBbVideoObject();
        if (TextUtils.isEmpty(configStr)) {
            return null;
        }

        BabyTestConfig babyTestConfig = null;
        try {
            Gson gSon = new Gson();
            java.lang.reflect.Type typeOfT = new com.google.gson.reflect.TypeToken<BabyTestConfig>() {
            }.getType();
            babyTestConfig = gSon.fromJson(configStr, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return babyTestConfig;
    }

    // 获取萌宝儿歌大全 是否开启AB测试 1开启 0关闭
    public String getABTest() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_test = "0";
        if (null != babyTestConfig) {
            ab_test = babyTestConfig.getAb_test_switch();
        }
        return ab_test;
    }

    // 获取萌宝儿歌大全 是否开启闪屏 1开启 0关闭
    public String getABSplashShow() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_splash_show = "0";
        if (null != babyTestConfig) {
            BabyTestConfig.BabyTestData dataBean = babyTestConfig.getAb_test_data();
            if (null != dataBean) {
                ab_splash_show = dataBean.getAb_splash_show();
            }
        }
        return ab_splash_show;
    }

    // 获取萌宝儿歌大全 是否开启视频前贴 1开启 0关闭
    public String getABVideoPreShow() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_pre_show = "0";
        if (null != babyTestConfig) {
            BabyTestConfig.BabyTestData dataBean = babyTestConfig.getAb_test_data();
            if (null != dataBean) {
                ab_pre_show = dataBean.getAb_pre_show();
            }
        }
        return ab_pre_show;
    }

    // 获取萌宝儿歌大全 宝宝看显示状态 1与点点显示一致 0原样显示
    public String getABVideoStatus() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_video_status = "0";
        if (null != babyTestConfig) {
            BabyTestConfig.BabyTestData dataBean = babyTestConfig.getAb_test_data();
            if (null != dataBean) {
                ab_video_status = dataBean.getAb_video_status();
            }
        }
        return ab_video_status;
    }

    // 获取萌宝儿歌大全 宝宝听显示状态 1与点点显示一致 0原样显示
    public String getABAudioStatus() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_audio_status = "0";
        if (null != babyTestConfig) {
            BabyTestConfig.BabyTestData dataBean = babyTestConfig.getAb_test_data();
            if (null != dataBean) {
                ab_audio_status = dataBean.getAb_audio_status();
            }
        }
        return ab_audio_status;
    }

    // 获取萌宝儿歌大全 AB测试渠道
    public String getABChannel() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String ab_channel = "";
        if (null != babyTestConfig) {
            BabyTestConfig.BabyTestData dataBean = babyTestConfig.getAb_test_data();
            if (null != dataBean) {
                ab_channel = dataBean.getAb_channel();
            }
        }
        return ab_channel;
    }

    // 获取萌宝儿歌大全 是否开启横幅广告2位 1开启 0关闭
    public String getBanner2Show() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String banner2_show_switch = "0";
        if (null != babyTestConfig) {
            banner2_show_switch = babyTestConfig.getBanner2_show_switch();
        }
        return banner2_show_switch;
    }

    // 获取萌宝儿歌大全 横幅广告2位不显示渠道
    public String getBanner2NotShowRule() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String banner2_not_show_rule = "";
        if (null != babyTestConfig) {
            banner2_not_show_rule = babyTestConfig.getBanner2_not_show_rule();
        }
        return banner2_not_show_rule;
    }

    // 获取萌宝儿歌大全 切换视频时是否切换广告 1切换 0不切换
    public String getSwitchBanner() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String switch_banner = "0";
        if (null != babyTestConfig) {
            switch_banner = babyTestConfig.getSwitch_banner();
        }
        return switch_banner;
    }

    // 获取萌宝儿歌大全 是否显示信息流广告 1显示 0关闭
    public String getInfoFlowSwitch() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String information_flow_switch = "0";
        if (null != babyTestConfig) {
            information_flow_switch = babyTestConfig.getInformation_flow_switch();
        }
        return information_flow_switch;
    }

    // 获取萌宝儿歌大全 是否显示宝宝看title广告 1显示 0关闭
    public String getVideoTitleBannerShow() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String video_title_banner_show = "";
        if (null != babyTestConfig) {
            video_title_banner_show = babyTestConfig.getVideo_title_banner_show();
        }
        return video_title_banner_show;
    }

    // 获取萌宝儿歌大全 是否显示宝宝听title广告 1显示 0关闭
    public String getAudioTitleBannerShow() {
        BabyTestConfig babyTestConfig = getBabyTestConfig();
        String audio_title_banner_show = "";
        if (null != babyTestConfig) {
            audio_title_banner_show = babyTestConfig.getAudio_title_banner_show();
        }
        return audio_title_banner_show;
    }

    // 保存儿歌点点 配置信息  测试专用
    public void saveErgeddObject(String strObject) {
        mUserSharedPreferences.edit().putString(KEY_ERGEDD_TEST, strObject).apply();
    }

    // 获取儿歌点点 配置信息  测试专用
    public String getErgeddObject() {
        return mUserSharedPreferences.getString(KEY_ERGEDD_TEST, "");
    }

    private ErgeTestConfig getErgeTestConfig() {
        String configStr = getErgeddObject();
        if (TextUtils.isEmpty(configStr)) {
            return null;
        }

        ErgeTestConfig ergeTestConfig = null;
        try {
            Gson gSon = new Gson();
            java.lang.reflect.Type typeOfT = new com.google.gson.reflect.TypeToken<ErgeTestConfig>() {
            }.getType();
            ergeTestConfig = gSon.fromJson(configStr, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ergeTestConfig;
    }

    // 获取儿歌点点 是否开启横幅广告2位 1开启 0关闭
    public String getErgeBanner2Show() {
        ErgeTestConfig ergeTestConfig = getErgeTestConfig();
        String banner2_show_switch = "0";
        if (null != ergeTestConfig) {
            banner2_show_switch = ergeTestConfig.getBanner2_show();
        }
        return banner2_show_switch;
    }

    // 获取儿歌点点 横幅广告2位不显示渠道
    public String getErgeBanner2NotShowRule() {
        ErgeTestConfig ergeTestConfig = getErgeTestConfig();
        String banner2_not_show_rule = "";
        if (null != ergeTestConfig) {
            banner2_not_show_rule = ergeTestConfig.getBanner2_not_show();
        }
        return banner2_not_show_rule;
    }

    // 获取儿歌点点 切换视频时是否切换广告 1切换 0不切换
    public String getErgeSwitchBanner() {
        ErgeTestConfig ergeTestConfig = getErgeTestConfig();
        String switch_banner = "0";
        if (null != ergeTestConfig) {
            switch_banner = ergeTestConfig.getSwitch_ad();
        }
        return switch_banner;
    }

    // 获取儿歌点点 是否显示信息流广告 1显示 0不显示
    public String getErgeInfoFlowShow() {
        ErgeTestConfig ergeTestConfig = getErgeTestConfig();
        String information_flow_switch = "0";
        if (null != ergeTestConfig) {
            information_flow_switch = ergeTestConfig.getInformation_flow_switch();
        }
        return information_flow_switch;
    }

    // bbvideo added version: 6.2.02
    // 保存萌宝儿歌大全 banner配置信息  测试专用
    public void saveBbVideoBannerObject(String strObject) {
        mUserSharedPreferences.edit().putString(KEY_BBVIDEO_BANNER_TEST, strObject).apply();
    }

    // bbvideo added version: 6.2.02
    // 获取萌宝儿歌大全 配置信息  测试专用
    public String getBbVideoBannerObject() {
        return mUserSharedPreferences.getString(KEY_BBVIDEO_BANNER_TEST, "");
    }

    // bbvideo added version: 6.2.02
    private BabyBannerConfig getBabyBannerConfig() {
        String configStr = getBbVideoBannerObject();
        if (TextUtils.isEmpty(configStr)) {
            return null;
        }

        BabyBannerConfig babyBannerConfig = null;
        try {
            Gson gSon = new Gson();
            java.lang.reflect.Type typeOfT = new com.google.gson.reflect.TypeToken<BabyBannerConfig>() {
            }.getType();
            babyBannerConfig = gSon.fromJson(configStr, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return babyBannerConfig;
    }

    // bbvideo added version: 6.2.02
    // 获取萌宝儿歌大全 获取banner规则专辑数据
    public List<BabyBannerAlbumData> getBabyBannerAlbumData() {
        BabyBannerConfig babyBannerConfig = getBabyBannerConfig();
        List<BabyBannerAlbumData> bannerAlbumDataList = new ArrayList<>();
        if (null != babyBannerConfig) {
            bannerAlbumDataList = babyBannerConfig.getAlbum_data();
        }
        return bannerAlbumDataList;
    }

    // bbvideo added version: 6.2.02
    // 获取萌宝儿歌大全 获取banner规则视频数据
    public List<BabyBannerVideoData> getBabyBannerVideoData() {
        BabyBannerConfig babyBannerConfig = getBabyBannerConfig();
        List<BabyBannerVideoData> bannerVideoDataList = new ArrayList<>();
        if (null != babyBannerConfig) {
            bannerVideoDataList = babyBannerConfig.getVideo_data();
        }
        return bannerVideoDataList;
    }

    // ergedd added version: 2.6.04
    // 保存儿歌点点 banner配置信息  测试专用
    public void saveErgeVideoBannerObject(String strObject) {
        mUserSharedPreferences.edit().putString(KEY_ERGEDD_BANNER_TEST, strObject).apply();
    }

    // ergedd added version: 2.6.04
    // 获取儿歌点点 配置信息  测试专用
    public String getErgeVideoBannerObject() {
        return mUserSharedPreferences.getString(KEY_ERGEDD_BANNER_TEST, "");
    }

    // ergedd added version: 2.6.04
    private BabyBannerConfig getErgeBannerConfig() {
        String configStr = getErgeVideoBannerObject();
        if (TextUtils.isEmpty(configStr)) {
            return null;
        }

        BabyBannerConfig babyBannerConfig = null;
        try {
            Gson gSon = new Gson();
            java.lang.reflect.Type typeOfT = new com.google.gson.reflect.TypeToken<BabyBannerConfig>() {
            }.getType();
            babyBannerConfig = gSon.fromJson(configStr, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return babyBannerConfig;
    }

    // ergedd added version: 2.6.04
    // 获取儿歌点点 获取banner规则专辑数据
    public List<BabyBannerAlbumData> getErgeBannerAlbumData() {
        BabyBannerConfig babyBannerConfig = getErgeBannerConfig();
        List<BabyBannerAlbumData> bannerAlbumDataList = new ArrayList<>();
        if (null != babyBannerConfig) {
            bannerAlbumDataList = babyBannerConfig.getAlbum_data();
        }
        return bannerAlbumDataList;
    }

    // ergedd added version: 2.6.04
    // 获取儿歌点点 获取banner规则视频数据
    public List<BabyBannerVideoData> getErgeBannerVideoData() {
        BabyBannerConfig babyBannerConfig = getErgeBannerConfig();
        List<BabyBannerVideoData> bannerVideoDataList = new ArrayList<>();
        if (null != babyBannerConfig) {
            bannerVideoDataList = babyBannerConfig.getVideo_data();
        }
        return bannerVideoDataList;
    }


    *//**
     * 存储ABTest动态host
     *
     * @param host
     *//*
    public void saveABHost(String host) {
        try {
            if (TextUtils.isEmpty(host)) return;
            mUserSharedPreferences.edit().putString(KEY_BBVIDEO_HOST_TEST, host).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    /**
     * 获取ABTest动态host
     *
     * @return
     */
    public String getABHost() {
        return mUserSharedPreferences.getString(KEY_BBVIDEO_HOST_TEST, "");
    }

    /**
     * 移除ABTest 动态Host
     */
    public void removeHost() {
        mUserSharedPreferences.edit().remove(KEY_BBVIDEO_HOST_TEST).apply();
    }
}
