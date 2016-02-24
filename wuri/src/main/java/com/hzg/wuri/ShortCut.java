package com.hzg.wuri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;

public class ShortCut {
	
	private static final String SHORTCUT_UNINSTALL = "com.android.launcher.action.UNINSTALL_SHORTCUT";
	
	/**
	 * 鍒ゆ柇妗岄潰鏄惁宸叉坊鍔犲揩鎹锋柟寮�
	 * 
	 * @param cx
	 * @param titleName
	 *            蹇嵎鏂瑰紡鍚嶇О
	 * @return
	 */
	public static boolean hasShortcut(Context cx) {
	    boolean result = false;
	    // 鑾峰彇褰撳墠搴旂敤鍚嶇О
	    String title = null;
	    try {
	        final PackageManager pm = cx.getPackageManager();
	        title = pm.getApplicationLabel(
	                pm.getApplicationInfo(cx.getPackageName(),
	                        PackageManager.GET_META_DATA)).toString();
	    } catch (Exception e) {
	    }

	    final String uriStr;
	    if (android.os.Build.VERSION.SDK_INT < 8) {
	        uriStr = "content://com.android.launcher.settings/favorites?notify=true";
	    } else {
	        uriStr = "content://com.android.launcher2.settings/favorites?notify=true";
	    }
	    final Uri CONTENT_URI = Uri.parse(uriStr);
//	    final Cursor c = cx.getContentResolver().query(CONTENT_URI, null,
//	            "title=?", new String[] { title }, null);
//	    if (c != null && c.getCount() > 0) {
//	        result = true;
//	    }
	    
	    final Cursor c = cx.getContentResolver().query(CONTENT_URI, null,
	            "", new String[]{}, null);
	    if (c != null && c.getCount() > 0) {
	    	for(int i=0; i<c.getCount(); i++){
	    		c.moveToPosition(i);
	    		for(int j=0; j<c.getColumnCount();j++){
	    			try{
	    				if(j == 15){
//	    					byte[] blob = c.getBlob(j);
//	    					if(blob != null)
//	    						for(int x = 0; x<blob.length; x++){
//	    							Log.e("","blog["+x+"]:"+blob[x]);
//	    						}
	    				}
	    				else
	    					COM.LOGE("", "i:" + i + "j:" + j + " name:" + c.getColumnName(j) + " value:" + c.getString(j));
	    			}
	    			catch(RuntimeException e){
	    				e.printStackTrace();
	    			}
	    		}
	    		c.moveToNext();
	    	}
	        result = true;
	    }
	    
	    return result;
	}
	
//	public static void creatShortCut(Context context)
//	{
//		
//		deleteCallShortcut(context);
//		
//	    Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
//
//	    ApplicationInfo appInfo = context.getApplicationInfo();
//	    
//	    // Shortcut name
//	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, context.getResources().getString(R.string.app_name)); //appInfo.name);
//	    shortcut.putExtra("duplicate", false); // Just create once
//
//	    // Setup activity shoud be shortcut object 
////	    ComponentName component = new ComponentName(appInfo.packageName, appInfo.className);
////	    ComponentName componentName = new ComponentName(context.getPackageName(), appInfo.className);// SplashActivity.class.getName());
////	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(componentName));
//
////	    Intent targetIntent=context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
//	    ComponentName componentName = new ComponentName(context.getPackageName(), ".ui.SplashActivity");
//	    
//	    Intent intent = new Intent(Intent.ACTION_MAIN);
//	    intent.addCategory(Intent.CATEGORY_LAUNCHER);
//	    intent.setComponent(componentName);
//	    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//	    intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//	    
//	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
//	    // Set shortcut icon
//	    ShortcutIconResource iconResource = Intent.ShortcutIconResource.fromContext(context, appInfo.icon);
//	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
//
//	    context.sendBroadcast(shortcut);
//	}
//
//	public static void deleteCallShortcut(Context context)
//	{
//	    Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
//
//	    ApplicationInfo appInfo = context.getApplicationInfo();
//
//	    // Shortcut name
//	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, context.getResources().getString(R.string.app_name));
//
//	    ComponentName comp = new ComponentName(appInfo.packageName, appInfo.className);// SplashActivity.class.getName()); //appInfo.className);
//	    shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));
//
//	    context.sendBroadcast(shortcut);
//	}
	
//		/** 
//		* 娣诲姞蹇嵎鏂瑰紡 
//		* */ 
		public static void creatShortCut(Activity activity) 
		{ 
			
		deleteCallShortcut(activity);
			
			int resourceId = R.drawable.ic_launcher;
		Intent intent = new Intent(); 
		intent.setClass(activity, MainActivity.class);
		/*浠ヤ笅涓ゅ彞鏄负浜嗗湪鍗歌浇搴旂敤鐨勬椂鍊欏悓鏃跺垹闄ゆ闈㈠揩鎹锋柟寮�*/ 
		intent.setAction("android.intent.action.MAIN"); 
		intent.addCategory("android.intent.category.LAUNCHER"); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		
		Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT"); 
		//涓嶅厑璁搁噸澶嶅垱寤� 
		shortcutintent.putExtra("duplicate", false); 
		//闇�瑕佺幇瀹炵殑鍚嶇О 
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, activity.getResources().getString(R.string.app_name)); 
		//蹇嵎鍥剧墖 
		Parcelable icon = Intent.ShortcutIconResource.fromContext(activity.getApplicationContext(), resourceId); 
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon); 
		//鐐瑰嚮蹇嵎鍥剧墖锛岃繍琛岀殑绋嬪簭涓诲叆鍙� 
		shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent); 
		//鍙戦�佸箍鎾�侽K 
		activity.sendBroadcast(shortcutintent); 
		} 
		
		private static void deleteCallShortcut(Activity activity) {
		    Intent shortcut = new Intent(SHORTCUT_UNINSTALL);  
		    //鍚嶅瓧瑕佸拰鍒涘缓鏃剁殑涓�鏍�  
		    shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, activity.getResources().getString(R.string.app_name));  
		      
		    //杩欓噷鐨刬ntent瑕佸拰鍒涘缓鏃剁殑intent璁剧疆涓�鑷�  
		    Intent intent = new Intent(); 
			intent.setClass(activity, MainActivity.class);//SplashActivity.class);
			/*浠ヤ笅涓ゅ彞鏄负浜嗗湪鍗歌浇搴旂敤鐨勬椂鍊欏悓鏃跺垹闄ゆ闈㈠揩鎹锋柟寮�*/ 
			intent.setAction("android.intent.action.MAIN"); 
			intent.addCategory("android.intent.category.LAUNCHER");             
		      
		    //鍙戦�佸箍鎾互鍒犻櫎shortcut  
			activity.sendBroadcast(shortcut);  
		      
		}  
}
