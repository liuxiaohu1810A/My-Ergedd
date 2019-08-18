package com.example.myergedd.utils;

/**
 * Created by dk on 17/6/23.
 */

public class RestUtil {
    private static RestUtil instance;
    long duration;

    private RestUtil() {

    }

    public static RestUtil getInstance() {
        if (instance == null)
            instance = new RestUtil();
        return instance;
    }

    public void addDuration(long add) {
        duration += add;
    }

    public long getDuration() {
        return duration;
    }

    public void reset() {
        duration = 0;

    }
}
