package com.hzg.wuri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

public class COM {
	public final static boolean DEBUG = false; 
	public final static boolean LOGTOFILE = DEBUG;
    public final static int INFO = 0;
    public final static int WAR = 1;
    public final static int ERR = 2;
    public final static int DBG_LEVEL = INFO;
    public static String ERRMSG_FILE = "/sdcard/errmsg.log";
    
    public static String BROADCAST_SET_NOTIFICATION_SHOWED = "BROADCAST_SET_NOTIFICATION_SHOWED";

	public static Data getTodayData(Context context){
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTimeZone(TimeZone.getDefault());
		calendarNow.setTimeInMillis(System.currentTimeMillis());
		
		Data data = new Data();
		data.month = calendarNow.get(Calendar.MONTH)+1;
		data.day = calendarNow.get(Calendar.DAY_OF_MONTH);
		
		data.info = context.getResources().getString(R.string.today)+" ";
		return data;
	}
	
	@SuppressLint("NewApi") public static void copy(Context context ,final String str){
		ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cmb.setText(str);
        ToastAPI.showShort(context, R.string.copy_ok);
    }
	
	 public static void LOGTOFILE_STR(String TAG,String str){
	        File file = new File(ERRMSG_FILE);
	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
	            fileOutputStream.write("\r\n\r\n".getBytes("GBK"));
	            if(TAG != null)
	                fileOutputStream.write(TAG.getBytes("GBK"));
	            fileOutputStream.write(":".getBytes("GBK"));
	            if(str != null)
	                fileOutputStream.write(str.getBytes("GBK"));
	            fileOutputStream.flush();
	            fileOutputStream.close();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
//				e.printStackTrace();
	        }catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }




		public static int getInt(String value)
		{
			int price = 0;
			
			try{
				price = Integer.parseInt(value);
			}catch(NumberFormatException e){
//				e.printStackTrace();
				price=0;
			}
					
			return price;
		}
		

		public static void LOGI(String TAG, String str){
			if(isDebug(INFO)){
					Log.i(TAG,str);
			}
		}
		
		public static void LOGW(String TAG, String str){
			if(isDebug(WAR)){
				Log.w(TAG,str);
			}
		}
		
		public static void LOGE(String TAG, String str){
			if(isDebug(ERR)){
				Log.e(TAG,str);
			}
		}
		
		public static boolean isDebug(int level){
	        if(DBG_LEVEL <= level && DEBUG)
	        {
	            return true;
	        }
	        else
	            return false;
	    }
	
}
