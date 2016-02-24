package com.hzg.wuri;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cg on 16-1-22.
 */
public class GWidget extends AppWidgetProvider {
    Context mContext;
    public static final String ACTION_WIDGET_UPDATE_BY_DATACHANGE = "com.hzg.wuri.ACTION_WIDGET_UPDATE_BY_DATACHANGE";

    int request = 0;
    public static int randomNumber = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        Log.e("yao", "HelloWidgetProvider --> onReceive appWidgetId:" + appWidgetId);

        if(intent != null){
            String action = intent.getAction();
            Log.e("yao", "action --> "+action);
            if(ACTION_WIDGET_UPDATE_BY_DATACHANGE.equals(action)){
                AppWidgetManager manager = AppWidgetManager.getInstance(context);
                int ids[]=manager.getAppWidgetIds(new ComponentName(mContext.getPackageName(), this.getClass().getName()));
                update(context, AppWidgetManager.getInstance(context), ids);
            }
        }
        super.onReceive(context, intent);
    }



    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.i("yao", "HelloWidgetProvider --> onDeleted");
        mContext = context;
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        Log.i("yao", "HelloWidgetProvider --> onEnabled");
        mContext = context;
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        mContext = context;
        super.onDisabled(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        update(context, appWidgetManager, appWidgetIds);
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    public synchronized void update(Context context, AppWidgetManager appWidgetManager,
                       int[] appWidgetIds){
        Log.i("yao", "HelloWidgetProvider --> onUpdate");
        mContext = context;
        int len = appWidgetIds.length;
        DataUtils mDataUtils;
        Data todayData = COM.getTodayData(mContext);
        String strToday = mContext.getString(R.string.today);
        String strNoAlarm = mContext.getString(R.string.no_alarm);
        for(int i=0; i<len ; i++){
            RemoteViews remote = new RemoteViews(context.getPackageName(),
                    R.layout.widget);
            mDataUtils = DataUtils.getInstance(mContext);
            Data data = mDataUtils.getWuRiData(todayData);
            if(data != null){
                remote.setTextViewText(R.id.textViewInfo, data.month + "-" + data.day + " " + data.info);
            }
            else{
                remote.setTextViewText(R.id.textViewInfo,strToday+" "+todayData.month+"-"+todayData.day+" "+strNoAlarm);
            }

            Intent intent = new Intent(mContext, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, request++,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);//
            remote.setOnClickPendingIntent(R.id.layoutall, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], remote);
//            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds[i], R.id.gridView);
        }
    }

    public static void updateBroadcast(Context context){
        if(context == null)
            return;
        Intent intent = new Intent(GWidget.ACTION_WIDGET_UPDATE_BY_DATACHANGE);
        context.sendBroadcast(intent);
    }
}
