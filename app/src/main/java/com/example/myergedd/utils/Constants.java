package com.example.myergedd.utils;


import com.example.myergedd.BabySongApplicationProxy;

/**
 * Created by maochen on 15/4/29.
 */
public class Constants {

    public static final String ERGEDD_ID = "com.mampod.ergedd";
    public static final String ERGEDD_GOOGLEPLAY_ID = "com.mampod.ergedd.gp";
    public static final String ENGLISH = "com.mampod.english";
    public static final String BABYBUS_VIDEO_ID = "com.sinyee.babybus.video";
    public static final String MAMPOD_SONG_JISU_ID = "com.mampod.song.jisu";

    // bbvideo added version: 6.2.04
    public static final String ERGEDD_GDT_FLAVOR = "ergedd_gdt";
    public static final String BABYBUS_GDT_FLAVOR = "bbvideo_gdt";

    public static final long VIDEO_REVIEW_LIMIT = 50L;
    public static final long AUDIO_REVIEW_LIMIT = 100L;

    public static final long VIDEO_ADVERTISEMENT_LIMIT_DEFAULT = 85L;
    public static final long AUDIO_ADVERTISEMENT_LIMIT_DEFAULT = 200L;

    public static final long VIDEO_AD_START_SECONDS_DEFAULT = 8L;

    public static final long SECOND_TIME = 1000;
    public static final long MIN_TIME = 60 * SECOND_TIME;
    public static final long HOUR_TIME = 60 * MIN_TIME;
    public static final long DAY_TIME = 24 * HOUR_TIME;

    public static final long AD_TIME_SPAN = Constants.MIN_TIME * 15;

    public static final int TAB_VIDEO = 0;
    public static final int TAB_AUDIO = 1;
    public static final int TAB_PROFILE = 2;

    public static final int TAB_CACHE_VIDEO_ALBUM = 0;
    public static final int TAB_CACHE_VIDEO = 1;
    public static final int TAB_CACHE_AUDIO = 2;

    public static final int KIDS_AGE_LEVVEL_NONE = -1;
    public static final int KIDS_AGE_LEVVEL_0 = 0;
    public static final int KIDS_AGE_LEVVEL_1 = 1;
    public static final int KIDS_AGE_LEVVEL_2 = 2;
    public static final int KIDS_AGE_LEVVEL_3 = 3;


    public static final long EXIT_TIME = 2 * SECOND_TIME;//两次back键的退出的事件的间隔
    public static final String DEFAULT_REFERER_KEY = "http://www.idreamo.com";

    //controll play strategy
    public static final int PLAY_STRATEGY_NONE = 21; // 无
    public static final int PLAY_STRATEGY_COUNT = 22; // 计数
    public static final int PLAY_STRATEGY_TIME = 23; // 计时

    //number controll
    public static final long UNLIMITED = 1000;
    public static final long COUNT_LIMIT_5 = 5;
    public static final long COUNT_LIMIT_10 = 10;
    public static final long COUNT_LIMIT_20 = 20;

    //time controll
    public static final long TIME_LIMIT_10 = 10 * MIN_TIME;
    public static final long TIME_LIMIT_15 = 15 * MIN_TIME;
    public static final long TIME_LIMIT_20 = 20 * MIN_TIME;
    public static final long TIME_LIMIT_30 = 30 * MIN_TIME;
    public static final long TIME_LIMIT_40 = 40 * MIN_TIME;
    public static final long TIME_LIMIT_45 = 45 * MIN_TIME;
    public static final long TIME_LIMIT_50 = 50 * MIN_TIME;
    public static final long TIME_LIMIT_60 = 60 * MIN_TIME;

    //play mode
    public static final int MODE_OPTION_ORDER = 12; // 顺序循环
    public static final int MODE_OPTION_SINGLE_CIRCLE = 13; // 单曲循环
    public static final int MODE_OPTION_RANDOM = 14; // 随机播放

    //video auto reset time
    public static final long VIDEO_AUTO_RESET_TIME = 2 * HOUR_TIME;


    public static final long TWO_DAT_TIME = 2 * DAY_TIME;
    public static final long SEVEN_DAY_TIME = 7 * DAY_TIME;
    public static final long THREE_MINS = 3 * MIN_TIME;

    public static final String COMMUNITRY_URL = "http://x.linduo.net/ergedd";
    public static final String ABOUT_URL = "http://www.ergedd.com/home/about-app";
    public static final String COOPERATION_URL = "http://www.ergedd.com/home/cooperate";
    public static final String MAMPOD_URL = "http://a.app.qq.com/o/simple.jsp?pkgname=com.mampod.ergedd";
    // 设置——微信公众号
    public static final String WECHAT_PAGE = "http://api.ergedd.com/h5static/gongzhonghao.html";


    //######################## MI ######################
    public static final String MI_APP_ID_EGDD = "2882303761517362910";
    public static final String MI_APP_KEY_EGDD = "5181736210910";

    public static final String MI_APP_ID_BB = "2882303761517305070";
    public static final String MI_APP_KEY_BB = "5431730591070";

    public static final String MIPUSH_SUBSCRIBE = "";

    public static final int REVIEW_STATUS_NEW_INSTALL = -1;
    public static final Long REVIEW_STATUS_REVIEWED = 0L;

    public static final String VIDEO_COLLECTION_NAME = "精选";
    public static final String PROFILE_FAVOURITE_NAME = "我喜欢的";
    public static final String PROFILE_DOWNLOAD_NAME = "我缓存的";
    public static final String MI_PUSH_NAME = "小米推送";
    public static final int LOCATION_VIDEO_COLLECTION = 1;
    public static final int LOCATION_SETTING = 2;
    public static final String SEARCH_NAME = "搜索";
    public static final String SETTING = "设置";
    public static final String VIDEO = "视频";
    public static final String AUDIO = "音频";
    public static final String NURSERY_RHYMES = "儿歌";
    public static final String STORY = "故事";

    public static final int minBuffTime = 3000; //满足上报时间限制

    // 上报Talkingdata 用户身份
    public static final String TOURISTS = "游客";
    public static final String REGULAR_MEMBERS = "普通会员";
    public static final String MEMBERS = "非连续VIP";
    public static final String CONTINUOUS_MEMBERS = "连续VIP";

    // 上报Talkingdata 入口
    public static final String AD_CLOSE = "广告关闭入口";
    public static final String VIDEO_DEFINITION = "视频高清入口";
    public static final String VIP_LIMIT = "设置会员权益入口";
    public static final String VIP_BUY = "设置购买会员入口";
    public static final String VIP_RENEW = "设置会员立即续费入口";

    // 建议反馈
    public static String FEEDBACK_URL = "https://wj.qq.com/s/2068055/051f";
    // 常见问题
    public static String QUESTION_URL = "http://api.ergedd.com/h5static/android.html";
    // 自动续费
    public static String RENEW_URL = "http://api.ergedd.com/h5static/android-xf.html";
    // 会员服务协议
    public static String AGREEMENT_URL = "http://api.ergedd.com/h5static/huiyuanxieyi.html";
    // 自动续费协议
    public static String RENEW_AGREEMENT_URL = "http://api.ergedd.com/h5static/lianxubaoyue.html";

    static {
        if (BabySongApplicationProxy.isEnglish()) {
            FEEDBACK_URL = "https://wj.qq.com/s/1179984/22ca";
        } else {
            FEEDBACK_URL = "https://wj.qq.com/s/2068055/051f";
        }
    }
}
