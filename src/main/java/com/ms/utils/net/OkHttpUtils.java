package com.ms.utils.net;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils {

    private OkHttpUtils() {
    }

    private static OkHttpClient mClient;

    public static OkHttpClient getClient() {
        if (mClient == null) {
            synchronized (OkHttpUtils.class) {
                mClient = new OkHttpClient.Builder().build();
            }
        }
        return mClient;
    }

    public static void doGet(String url, Callback callback) {
        getClient().newCall(new Request.Builder().build()).enqueue(callback);

    }

}
