package com.ls.myshop.Base;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.ls.myshop.utils.LruImageCache;

/**
 * Created by ls on 16/1/29.
 */
public class MainApplication extends Application {
    private static MainApplication mContext;
    private static RequestQueue requestQueue;
    private static LruImageCache lruImageCache;
    private static ImageLoader imageLoader;

    /**
     * 获取全局上下文
     *
     * @return 返回上下文
     */
    public static Context getAppContext() {
        return mContext;
    }

    /**
     * 获取请求队列
     *
     * @return 返回请求队列
     */
    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
        lruImageCache = LruImageCache.instance();
        imageLoader = new ImageLoader(requestQueue, lruImageCache);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
