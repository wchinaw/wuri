package com.hzg.wuri;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class WuRiService extends Service{
	Data mToday;
	DataUtils mDataUtils;
	boolean isTodayAlarmed = false;
	Context mContext;
	Thread mGardThread; 
	
	BroadcastReceiver mBroadcastReceiver;
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		mContext = this;
		mDataUtils = DataUtils.getInstance(getApplicationContext());
		setupBroadcast();
		startGardThread();
	}
	
	public void setupBroadcast(){
		mBroadcastReceiver = new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				if(arg1 != null){
					String action = arg1.getAction();
					if(COM.BROADCAST_SET_NOTIFICATION_SHOWED.equals(action)){
						isTodayAlarmed = true;
						GWidget.updateBroadcast(mContext);
					}
				}
				
			}
		};
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(COM.BROADCAST_SET_NOTIFICATION_SHOWED);;
		
		registerReceiver(mBroadcastReceiver, filter);
	}
	
	
	
	public void stopGardThread(){
		if(mGardThread != null && mGardThread.isAlive()){
			mGardThread.interrupt();
		}
	}
	
	public void startGardThread(){
		mToday = mDataUtils.getTodayWuRiData();
//		stopGardThread();
		mGardThread = new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
//						Thread.sleep(60000*10);
						Thread.sleep(60000);
//						Log.e("","Thread.sleep(6000)");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Data data = mDataUtils.getTodayWuRiData();
					
					
//					Calendar calendarNow = Calendar.getInstance();
//					calendarNow.setTimeZone(TimeZone.getDefault());
//					calendarNow.setTimeInMillis(System.currentTimeMillis());
//					int hour = calendarNow.get(Calendar.HOUR_OF_DAY);
//					int minute = calendarNow.get(Calendar.MINUTE);
					
//					if(mToday != null){
//						Log.e("","mToday day:"+mToday.day);
//						Log.e("","mToday month:"+mToday.month);
//						Log.e("","mToday info:"+mToday.info);
//					}
//					else{
//						Log.e("","mToday: == null");
//					}
					
					if(data != null){
//						Log.e("","data day:"+data.day);
//						Log.e("","data month:"+data.month);
//						Log.e("","data info:"+data.info);
						if(mToday != null){
							if(data.day != mToday.day || data.month != mToday.month){
								mToday = data;
								isTodayAlarmed = false;
							}
						}
						else{
							mToday = data;
							isTodayAlarmed = false;
						}						
					}
					else{
						Log.e("","data: == null");
					}
					
					Log.e("","isTodayAlarmed:"+isTodayAlarmed);
					
//					isTodayAlarmed = false;
					
					if(!isTodayAlarmed && data != null){ // && hour == 6 && minute>=0
						isTodayAlarmed = true;
//						Log.e("","now alarm...");
						NotificationTools.showNotification(mContext, R.string.alarm, data.info);
						GWidget.updateBroadcast(mContext);
					}
				}
			}
		});
		
		mGardThread.start();
	}

	@Override
	public void onDestroy() {
		unregisterReceiver(mBroadcastReceiver);
		super.onDestroy();
	}
	
	

}
