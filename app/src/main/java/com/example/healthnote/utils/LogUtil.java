package com.example.healthnote.utils;

import android.util.Log;


public class LogUtil {

    public static void e(String message) {
        while (message.length() >= 2000) {
            Log.e("tag", message.substring(0, 2000));
            message = message.substring(2000);
        }
        Log.e("tag", message);
    }
}
