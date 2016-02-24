package com.hzg.wuri;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
	Context mContext;
	static Settings mInstance;
    SharedPreferences mPreference;
    SharedPreferences.Editor mEditor;
    public static String WURI = "WURI";
    
    public static final String KEY_APP_IS_CREATE_SHORTCUT = "KEY_APP_IS_CREATE_SHORTCUT";
    
    private Settings()
    {
        mContext = MyApp.getInstance();
        mPreference = mContext.getSharedPreferences(WURI, Context.MODE_PRIVATE);
        mEditor = mPreference.edit();
    }

    public String getString(String key){
        return getString(key, "");
    }

    public String getString(String key, String defValue){
            return mPreference.getString(key, defValue);
    }


    public void putString(String key, String value){
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public static Settings getInstance(){
        if(mInstance == null){
            mInstance = new Settings();
        }
        return mInstance;
    }


    public long getLong(String key, long defaultValue){
        return mPreference.getLong(key, defaultValue);
    }

    public long getLong(String key){
        return getLong(key, 0);
    }

    public void putLong(String key, long value){
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    public int getInt(String key){
            return mPreference.getInt(key, 0);
    }

    public int getInt(String key, int defValue){
            return mPreference.getInt(key, defValue);
    }

    public void putBoolean(String key, boolean value){
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public boolean getBoolean(String key){
        return mPreference.getBoolean(key, false);
    }

    
    public void putInt(String key, int value){
 
            mEditor.putInt(key, value);
            mEditor.commit();
    }
}
