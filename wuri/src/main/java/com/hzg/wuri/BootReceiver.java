package com.hzg.wuri;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
        	Data data = DataUtils.getInstance(context).getTodayWuRiData();
        	if(data != null){
        		NotificationTools.showNotification(context, R.string.alarm, data.info);
        	}
//        	COM.LOGE("mobjam BootReceiver", "ACTION_BOOT_COMPLETED startService");
//        	MainTabActivity.startWBService(null, context, SQLiteHelper.getInstance(context),GlobalSetting.APP_BACKGROUND);
        }
    }
}
