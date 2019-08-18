package com.example.myergedd;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;


import com.example.myergedd.utils.Constants;

import java.util.List;

/**
 * Created by dk on 16/12/28.
 */

public class BabySongApplicationProxy {

    private static Application mApplication;

    public static Application getApplication() {
        return mApplication;
    }

    public static void setApplication(Application mApplication) {
        BabySongApplicationProxy.mApplication = mApplication;
    }

    public static boolean isErgedd() {
        return BuildConfig.APPLICATION_ID.equals(Constants.ERGEDD_ID);
    }

    public static boolean isErgeddGooglePlay() {
        return BuildConfig.APPLICATION_ID.equals(Constants.ERGEDD_GOOGLEPLAY_ID);
    }

    public static boolean isEnglish() {
        return BuildConfig.APPLICATION_ID.equals(Constants.ENGLISH);
    }

    public static boolean isBBVideo() {
        return BuildConfig.APPLICATION_ID.equals(Constants.BABYBUS_VIDEO_ID);
    }

    public static boolean isMampodSongJisu() {
        return BuildConfig.APPLICATION_ID.equals(Constants.MAMPOD_SONG_JISU_ID);
    }

    // bbvideo added version: 6.2.04
    public static boolean isErgeddGdt() {
        return BuildConfig.FLAVOR.equals(Constants.ERGEDD_GDT_FLAVOR);
    }

    // bbvideo added version: 6.2.04
    public static boolean isBbvideoGdt() {
        return BuildConfig.FLAVOR.equals(Constants.BABYBUS_GDT_FLAVOR);
    }

    public static boolean isInFrontground() {
        ActivityManager am = ((ActivityManager) getApplication().getSystemService(Context.ACTIVITY_SERVICE));
        if (am != null) {
            List<ActivityManager.RunningTaskInfo> taskInfoList = am.getRunningTasks(1);

            if (taskInfoList != null && taskInfoList.size() > 0) {
                android.app.ActivityManager.RunningTaskInfo taskInfo = taskInfoList.get(0);

                if (taskInfo != null) {
                    String currentApplicationPackageName = taskInfo.baseActivity.getPackageName();
                    if (currentApplicationPackageName.equals(getApplication().getPackageName())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
