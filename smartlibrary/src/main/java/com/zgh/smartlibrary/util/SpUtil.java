package com.zgh.smartlibrary.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Wu Jingyu
 * Date: 2015/10/29
 * Time: 16:33
 */
public class SpUtil {
    private static final String SP_NAME = "sp_file";
    private SharedPreferences sp = null;
    private SharedPreferences.Editor edit = null;
    private static Context mContext;

    private static class LazyHolder {
        private static final SpUtil INSTANCE = new SpUtil(mContext);
    }

    public static SpUtil getInstance(Context context) {
        mContext = context;
        return LazyHolder.INSTANCE;
    }

    private SpUtil(Context context) {
        this(context.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE));
    }

    private SpUtil(SharedPreferences sp) {
        this.sp = sp;
        edit = sp.edit();
    }

    public void setValue(String key, boolean value) {
        edit.putBoolean(key, value);
        edit.commit();
    }

    public void setValue(String key, float value) {
        edit.putFloat(key, value);
        edit.commit();
    }

    public void setValue(String key, int value) {
        edit.putInt(key, value);
        edit.commit();
    }

    public void setValue(String key, long value) {
        edit.putLong(key, value);
        edit.commit();
    }

    public void setValue(String key, String value) {
        edit.putString(key, value);
        edit.commit();
    }

    public boolean getBoolValue(String key) {
        return sp.getBoolean(key, false);
    }

    public float getFloatValue(String key) {
        return sp.getFloat(key, 0);
    }

    public int getIntegerValue(String key) {
        return sp.getInt(key, 0);
    }
    public int getIntegerValue(String key,int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public long getLongValue(String key) {
        return sp.getLong(key, 0);
    }

    public String getStringValue(String key) {
        return sp.getString(key, "");
    }

    public void remove(String key) {
        edit.remove(key);
        edit.commit();
    }

    public void clear() {
        edit.clear();
        edit.commit();
    }

    public boolean contains(String s) {
        return sp.contains(s);
    }
}

