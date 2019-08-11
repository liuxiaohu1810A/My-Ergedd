package com.example.myergedd.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myergedd.app.MyApp;

public class ToastUtils {
    public static void ShowToast(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Toast.makeText(MyApp.getInstance(), text, Toast.LENGTH_SHORT).show();
    }
}
