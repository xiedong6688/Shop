package com.ls.myshop.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by ls on 16/1/29.
 */
public class LruImageCache implements ImageLoader.ImageCache {
    private static LruCache<String, Bitmap> mMemoryCache;

    private static LruImageCache lruImageCache;

    private LruImageCache() {
        // Get the Max available memory
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    public static LruImageCache instance() {
        if (lruImageCache == null) {
            lruImageCache = new LruImageCache();
        }
        return lruImageCache;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        if (getBitmap(url) == null) {
            mMemoryCache.put(url, bitmap);
        }
    }
}
