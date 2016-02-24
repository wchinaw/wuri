package com.hzg.wuri;

import android.content.Context;
import android.widget.Toast;

public class ToastAPI {
	private static Toast toast = null;
	public static void showShort(Context context, String str){
		if(context != null && str != null && str.length()>0){			
			Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
		}
	}
	
	public static void showShortWithCancel(Context context, String str){
		if(context != null && str != null && str.length()>0){	
			if(toast != null){
				toast.cancel();		
				toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
			}else{
				toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);							
			}			
			toast.show();
		}
	}
	public static void showShort(Context context, int strId){
		if(context == null)
			return;
//		TextView txt = new TextView(context);
//		txt.setText(strId);
//		
//		txt.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				COM.LOGE("", "Toast Click ok .:)");
//			}
//		});
//		
//		Toast t = new Toast(context);
//		t.setView(txt);
//		t.show();

        if(toast != null){
            toast.cancel();
            toast = Toast.makeText(context, strId, Toast.LENGTH_SHORT);
        }else{
            toast = Toast.makeText(context, strId, Toast.LENGTH_SHORT);
        }
        toast.show();
//		View view = t.getView();
//		view.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				COM.LOGE("", "Toast Click ok .:)");
//			}
//		});
//		t.show();
//		if(strId>0)
//			Toast.makeText(context, strId, Toast.LENGTH_SHORT).show();
	}
}
