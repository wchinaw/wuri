package com.hzg.wuri;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.TypedValue;


public class MyApp extends Application {  
	// 共享变量  
	private Handler handler = null;  
	private int year;
	private int month;
	private int day;

	public int FaceOrBack;
	public boolean alreadytoast = false;
	private static MyApp mContext = null;

	private int mEmoHeight = 0;
//	private String mAuthCode;
//	private UserSetting mUserSetting;
	private int mServerTime;
	private int mLocalTime;
//	private SQLiteHelper mSQLiteHelper;
	
//	public void setUserSetting(UserSetting set){
//		mUserSetting = set;
//	}
	
	public void setServerTime(int sys){
		if(sys > 0){
			mServerTime = sys;
			mLocalTime = (int) (System.currentTimeMillis()/1000);
		}
	}
	
	public int getCurrentTime(){
		return (int)(System.currentTimeMillis()/1000)-mLocalTime+mServerTime;
	}
	
//	public void saveUserSetting(){
//		if(mUserSetting != null){
//			SQLiteHelper.getInstance(mContext).insertUserSetting(mUserSetting);
//		}
//	}
	
	
	
	@Override
	public void onCreate() {
		mContext = this;
		super.onCreate();
	}
	
	public int getEmoHeight(){
		return mEmoHeight;
	}
	
//	public void setUid(int uid){
//		mUid = uid;
//	}
	
	public static MyApp getInstance(){
		if(mContext == null)
			mContext = new MyApp();
		return mContext;
	}
	
	public static Context getContext()
	{
		return mContext;
	}	
}  