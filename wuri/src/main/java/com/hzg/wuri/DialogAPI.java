package com.hzg.wuri;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class DialogAPI {
	
	final static String TAG = "DialogAPI";
	public static Dialog mProgressDialog = null;
	public static Dialog mDialogTwoButton = null;
	public static Dialog mDialogHozThreeButton = null;
	public static Dialog mConfirmDialog = null;
	public static Dialog mDialogHozTwoButton = null;
	
	public static Dialog mDialogHozOneButton = null;
	
	public static Dialog mDialogHozSixButton = null;
	

	
//	public static Dialog ProgressDialog(Activity context , Object dismissActivity,int text,boolean isBlock){
//		if(context == null){
//			COM.LOGE("ProgressDialog","ERR activity == null!");
//			return null;
//		}
//		
//		hideProgressDialog(context);		
//		mProgressDialog = null;	
//		if(isBlock){
//			mProgressDialog = new Dialog(context,R.style.ThemeActivity);
//			Window window = mProgressDialog.getWindow();		
//			int screenWidth =LayoutParams.FILL_PARENT;
//			int screenHeight = LayoutParams.FILL_PARENT;
//			LayoutParams params0 = window.getAttributes();
//			params0.width = screenWidth;
//			params0.height = screenHeight;
//			window.setAttributes(params0);
//		}else{
//			mProgressDialog = new Dialog(context, R.style.CustomDialogStyle);
//		
//		}
//		mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		
//		View loadingDialog = View.inflate(context,R.layout.progressbar, null);
//		TextView p_text=(TextView)loadingDialog.findViewById(R.id.load_text);
//		
//		if(text != 0)
//		{
//			p_text.setText(text);
//			p_text.setVisibility(View.VISIBLE);
//		}
//		
//		mProgressDialog.setContentView(loadingDialog);
//	
//		if(dismissActivity != null){
//			if(dismissActivity instanceof BaseActivity){
//				mProgressDialog.setOnDismissListener((BaseActivity)dismissActivity);
//			}
//			else if(dismissActivity instanceof Fragment){
//				mProgressDialog.setOnDismissListener((BaseFragment)dismissActivity);
//			}
//			else{
//				COM.LOGE(TAG, "Warning no OnDismissListener set.");
//			}
//		}
//		
//		mProgressDialog.show();
//		return mProgressDialog;
//	}
//	public static Dialog ProgressDialog(final Activity activity , Object dismissActivity,int text){
//		
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}		
//		mProgressDialog = new Dialog(activity,R.style.ThemeActivity);
//		Window window = mProgressDialog.getWindow();		
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		WindowManager.LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
//		window.setAttributes(params0);
//		mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		View loadingDialog = View.inflate(activity,R.layout.progressbar, null);
//		TextView p_text=(TextView)loadingDialog.findViewById(R.id.load_text);		
//		if(text != 0)
//		{
//			p_text.setText(activity.getResources().getString(text));
//			p_text.setVisibility(View.VISIBLE);
//			
//		}
//		mProgressDialog.setContentView(loadingDialog);
//		if(dismissActivity != null){
//			if(dismissActivity instanceof BaseActivity){
//				mProgressDialog.setOnDismissListener((BaseActivity)dismissActivity);
//			}
//			else if(dismissActivity instanceof Fragment){
//				mProgressDialog.setOnDismissListener((BaseFragment)dismissActivity);
//			}
//			else{
//				COM.LOGE(TAG, "Warning no OnDismissListener set.");
//			}
//		}
//		mProgressDialog.show();
//		return mProgressDialog;
//	}
	
	public static void hideProgressDialog(){
		if(mProgressDialog != null && mProgressDialog.isShowing()){
			COM.LOGI("hideProgressDialog", "mProgressDialog close");
			mProgressDialog.dismiss();
			mProgressDialog = null;
		}
	}
	
     public static void hideProgressDialog(Context context){
		if(mProgressDialog != null && mProgressDialog.isShowing()){
//			if(context == mProgressDialog.getContext()){
				COM.LOGE("hideProgressDialog", "mProgressDialog getOwnerActivity():"+mProgressDialog.getOwnerActivity()+" context:"+context);
				mProgressDialog.dismiss();
				mProgressDialog = null;
//			}
		}
	}
//     public static Dialog alertDialogTwoButton(final Activity activity,String title){
// 		
// 		if(activity == null){
// 			COM.LOGE("alertDialogId", "ERR activity == null!");
// 			return null;
// 		}
// 		
// 		AlertDialog.Builder builder = new Builder(activity);
//		builder.setMessage(title); 
//		builder.setPositiveButton(R.string.cancel,
//				new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface dialog,
//							int which) {
//					    
//						dialog.dismiss();
//					}
//				});
//		builder.setNegativeButton(R.string.ok,
//				new DialogInterface.OnClickListener() {
//					@Override
//					public void onClick(DialogInterface dialog,
//							int which) {
//
//						dialog.dismiss();
//						
//					}
//				});
//
// 		Dialog alert= new Dialog(activity);
// 		alert= builder.create();
// 		
// 		
// 		return alert;
// 	}
     
//     public static Dialog listDialog3Button(final Activity activity,
//    		 int nameId1, int nameId2, int nameId3,
//    		 final ConfirmDialog3ItemsListener listener, final ChatMessage msg){
//
//    		if(activity == null){
//    			COM.LOGE("alertDialogId", "ERR activity == null!");
//    			return null;
//    		}
//
//    		Builder builder = new Builder(activity);
////   		builder.setMessage(title);
//   		builder.setNegativeButton(nameId1,
//   				new DialogInterface.OnClickListener() {
//   					@Override
//   					public void onClick(DialogInterface dialog,
//   							int which) {
//   						listener.onItem1(msg);
//   						dialog.dismiss();
//
//   					}
//   				})
//   				.setNeutralButton(nameId2, new DialogInterface.OnClickListener() {
//   					@Override
//   					public void onClick(DialogInterface dialog,
//   							int which) {
//   						listener.onItem2(msg);
//
//   						dialog.dismiss();
//
//   					}
//   				})
//   				.setPositiveButton(nameId3, new DialogInterface.OnClickListener() {
//   					@Override
//   					public void onClick(DialogInterface dialog,
//   							int which) {
//   						listener.onItem3(msg);
//
//   						dialog.dismiss();
//
//   					}
//   				});
////   				;
//
////    		Dialog alert= new Dialog(activity);
//   		Dialog alert;
//    		alert= builder.create();
//    		alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//    		alert.show();
//    		return alert;
//    	}
//
//     public static Dialog alertDialogOneButton(final Activity activity,int title,final ConfirmDialogListener listener, final int id){
//
//   		if(activity == null){
//   			COM.LOGE("alertDialogId", "ERR activity == null!");
//   			return null;
//   		}
//
//   		Builder builder = new Builder(activity);
////  		builder.setMessage(title);
//  		builder.setNegativeButton(title,
//  				new DialogInterface.OnClickListener() {
//  					@Override
//  					public void onClick(DialogInterface dialog,
//  							int which) {
//  						listener.onOK(id);
//
//  						dialog.dismiss();
//
//  					}
//  				});
//
////   		Dialog alert= new Dialog(activity);
//  		Dialog alert;
//   		alert= builder.create();
//   		alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//   		alert.show();
//   		return alert;
//   	}
//
//     public static Dialog alertDialogOneButton(final Activity activity,String title,final ConfirmDialogListener listener){
//
//  		if(activity == null){
//  			COM.LOGE("alertDialogId", "ERR activity == null!");
//  			return null;
//  		}
//
//  		Builder builder = new Builder(activity);
//// 		builder.setMessage(title);
// 		builder.setNegativeButton(R.string.ok,
// 				new DialogInterface.OnClickListener() {
// 					@Override
// 					public void onClick(DialogInterface dialog,
// 							int which) {
// 						listener.onOK(null);
// 						dialog.dismiss();
//
// 					}
// 				});
//
////  		Dialog alert= new Dialog(activity);
// 		Dialog alert;
//  		alert= builder.create();
//  		alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//  		alert.show();
//  		return alert;
//  	}
//
	public interface ConfirmDialogListener{
		public void onOK(Object obj); //鎸夌‘璁ら敭
		public void onCancel(Object obj);//鎸塨ack閿�
	}
//
	public interface ConfirmDialog3ItemsListener{
		public void onItem1(Object obj);
		public void onItem2(Object obj);
		public void onItem3(Object obj);
	}
// 	public interface ConfirmDialog4ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//	}
//
// 	public interface ConfirmDialog5ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//		public void onItem5(Object obj);
//	}
//
// 	public interface ConfirmDialog6ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//		public void onItem5(Object obj);
//		public void onItem6(Object obj);
//	}
//
// 	public interface ConfirmDialog7ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//		public void onItem5(Object obj);
//		public void onItem6(Object obj);
//		public void onItem7(Object obj);
//	}
//
// 	public interface ConfirmDialog8ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//		public void onItem5(Object obj);
//		public void onItem6(Object obj);
//		public void onItem7(Object obj);
//		public void onItem8(Object obj);
//	}
//
// 	public interface ConfirmDialog9ItemsListener{
//		public void onItem1(Object obj);
//		public void onItem2(Object obj);
//		public void onItem3(Object obj);
//		public void onItem4(Object obj);
//		public void onItem5(Object obj);
//		public void onItem6(Object obj);
//		public void onItem7(Object obj);
//		public void onItem8(Object obj);
//		public void onItem9(Object obj);
//	}
//
	public static void hideDialogTwoButton()
	{
		if(mDialogTwoButton != null){
			try{
				mDialogTwoButton.dismiss();
			}
			catch(IllegalArgumentException e){
				e.printStackTrace();
			}
			mDialogTwoButton = null;
		}
	}
	public static void hideDialogHozTwoButton()
	{
		if(mDialogHozTwoButton != null){
			mDialogHozTwoButton.dismiss();
			mDialogHozTwoButton = null;
		}
	}
//
	public static void hideDialogThreeButton()
	{
		if(mDialogHozThreeButton != null){
			mDialogHozThreeButton.dismiss();
			mDialogHozThreeButton = null;
		}
	}
 	
//     public static Dialog DialogTwoButton(final Activity activity,final Object obj, final ConfirmDialog3ItemsListener listener,
//    		 int titleid ,int msgid,int content1RsId, int content2RsId ){
//
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}
//
//		mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
////		params0.windowAnimations = android.R.anim.fade_in;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
//		View loadingDialog = View.inflate(activity,R.layout.dialog_two_button, null);
//		RelativeLayout rl = (RelativeLayout) loadingDialog.findViewById(R.id.dialog_rl);
//		LinearLayout title1 = (LinearLayout) loadingDialog.findViewById(R.id.title);
//		TextView topClick = (TextView) loadingDialog.findViewById(R.id.left_text);
//		TextView bottomClick = (TextView) loadingDialog.findViewById(R.id.right_text);
//		TextView title = (TextView) loadingDialog.findViewById(R.id.textView1);
//		TextView msg = (TextView) loadingDialog.findViewById(R.id.textView2);
//		topClick.setText(content1RsId);
//		bottomClick.setText(content2RsId);
//		if(titleid == 0){
//			title1.setVisibility(View.GONE);
//
//		}
//		else{
//			title1.setVisibility(View.VISIBLE);
//			title.setText(titleid);
//		}
//		msg.setText(msgid);
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
//		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
//		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
//// 		imgTop.setImageResource(icon1RsId);
//// 		imgBottom.setImageResource(icon2RsId);
//
//		txtTop.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				listener.onItem1(obj);
//				hideDialogTwoButton();
//			}
//
//		});
//
//		txtBottom.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//
//				listener.onItem2(obj);
//				hideDialogTwoButton();
//			}
//
//		});
//		rl.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
////				listener.onItem3(obj);
////				hideDialogHozTwoButton();
//			}
//
//		});
//		mDialogTwoButton.setContentView(loadingDialog);
//
//		mDialogTwoButton.show();
//
//		return mDialogTwoButton;
//	}
//
//     public static Dialog DialogTwoButtonWithChangTitle(final Activity activity,final Object obj, final ConfirmDialog3ItemsListener listener,
//    		 String titleid ,int msgid,int content1RsId, int content2RsId ){
//
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 		mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
////		params0.windowAnimations = android.R.anim.fade_in;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
// 		View loadingDialog = View.inflate(activity,R.layout.dialogtwobuttonwithchangtitle, null);
// 		RelativeLayout rl = (RelativeLayout) loadingDialog.findViewById(R.id.dialog_rl);
// 		TextView topClick = (TextView) loadingDialog.findViewById(R.id.left_text);
// 		TextView bottomClick = (TextView) loadingDialog.findViewById(R.id.right_text);
// 		TextView title = (TextView) loadingDialog.findViewById(R.id.textView1);
// 		TextView msg = (TextView) loadingDialog.findViewById(R.id.textView2);
// 		topClick.setText(content1RsId);
// 		bottomClick.setText(content2RsId);
// 		title.setText(titleid);
// 		msg.setText(msgid);
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
// 		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
// 		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
//// 		imgTop.setImageResource(icon1RsId);
//// 		imgBottom.setImageResource(icon2RsId);
//
// 		txtTop.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem1(obj);
// 				hideDialogTwoButton();
// 			}
//
// 		});
//
// 		txtBottom.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
//
// 				listener.onItem2(obj);
// 				hideDialogTwoButton();
// 			}
//
// 		});
// 		rl.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
////				listener.onItem3(obj);
////				hideDialogHozTwoButton();
//			}
//
// 		});
// 		mDialogTwoButton.setContentView(loadingDialog);
//
//
//
// 		mDialogTwoButton.show();
// 		return mDialogTwoButton;
// 	}
//
//     public static Dialog DialogHozThreeButton(final Activity activity,final Object obj, final ConfirmDialog3ItemsListener listener,
//    		 int one ,int two,int three){
//
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}
//
//		mDialogHozThreeButton = new Dialog(activity,R.style.ThemeActivity);
//		Window window = mDialogHozThreeButton.getWindow();
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
//		window.setAttributes(params0);
//		mDialogHozThreeButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		View loadingDialog = View.inflate(activity,R.layout.chooseperson, null);
//
//		TextView topText = (TextView) loadingDialog.findViewById(R.id.person1);
//		TextView middleText = (TextView) loadingDialog.findViewById(R.id.person2);
//		TextView bottomText = (TextView) loadingDialog.findViewById(R.id.person3);
//		RelativeLayout layout_fourbtn = (RelativeLayout) loadingDialog.findViewById(R.id.layout_fourbtn);
//		topText.setText(one);
//		middleText.setText(two);
//		bottomText.setText(three);
//
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
//		topText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				listener.onItem1(obj);
//				hideDialogThreeButton();
//			}
//
//		});
//
//		middleText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				listener.onItem2(obj);
//				hideDialogThreeButton();
//			}
//
//		});
//		bottomText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				listener.onItem3(obj);
//				hideDialogThreeButton();
//			}
//
//		});
//		layout_fourbtn.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				hideDialogThreeButton();
//			}
//
//		});
//		mDialogHozThreeButton.setContentView(loadingDialog);
//		mDialogHozThreeButton.show();
//
//
//		return mDialogHozThreeButton;
//	}
//
//
//     public static Dialog DialogHozTwoButton(final Activity activity,final Object obj, final ConfirmDialog3ItemsListener listener,
//    		 int one ,int two){
//
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}
//
//
//		mDialogHozTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//
//		mDialogHozTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
//		View loadingDialog = View.inflate(activity,R.layout.mydiary_more, null);
//
//		TextView topText = (TextView) loadingDialog.findViewById(R.id.mydiary_more_share);
//
//		TextView bottomText = (TextView) loadingDialog.findViewById(R.id.mydiary_more_change);
//		RelativeLayout rl = (RelativeLayout) loadingDialog.findViewById(R.id.dialog_twobtn);
//		topText.setText(one);
//
//		bottomText.setText(two);
//
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
//
//
//
//
//
//		topText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				listener.onItem1(obj);
//				hideDialogHozTwoButton();
//			}
//
//		});
//
//
//		bottomText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				listener.onItem2(obj);
//				hideDialogHozTwoButton();
//			}
//
//		});
//
//		rl.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
////				listener.onItem3(obj);
//				hideDialogHozTwoButton();
//
//			}
//
//		});
//
//
//		Window window = mDialogHozTwoButton.getWindow();
//
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int screenWidth = (int) (dm.widthPixels);
//
//
//
////		Log.i("test", "寮瑰嚭dialog鐨勯暱瀹�"+screenWidth);
//
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//
//
//		window.setAttributes(params0);
//		mDialogHozTwoButton.setContentView(loadingDialog);
//		mDialogHozTwoButton.show();
//		return mDialogHozTwoButton;
//	}



//
//     public static Dialog DialogHozFourButton(final Activity activity,final Object obj, final ConfirmDialog4ItemsListener listener,
//    		 final int one ,final int two ,final int three, final int four ){
//
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
//
// 		final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//
// 		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
// 		View loadingDialog = View.inflate(activity,R.layout.ta_diary_more, null);
//
// 		TextView oneText = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
// 		TextView twoText = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
// 		TextView threeText = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
// 		TextView fourText = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
//
// 		oneText.setText(one);
// 		twoText.setText(two);
// 		threeText.setText(three);
// 		fourText.setText(four);
// 		oneText.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(obj == null){
// 				String	dd = v.getResources().getString(one);
// 					listener.onItem1(dd);
// 				}else{
// 					listener.onItem1(obj);
// 				}
// 				if(dialog != null)
// 					dialog.dismiss();
// 			}
//
// 		});
//
//
// 		twoText.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(obj == null){
// 	 				String	dd = v.getResources().getString(two);
// 	 					listener.onItem2(dd);
// 	 				}else{
// 	 				listener.onItem2(obj);
// 	 				}
// 				if(dialog != null)
// 					dialog.dismiss();
// 			}
//
// 		});
// 		threeText.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(obj == null){
// 	 				String	dd = v.getResources().getString(three);
// 	 					listener.onItem3(dd);
// 	 				}else{
// 	 				listener.onItem3(obj);
// 	 				}
// 				if(dialog != null)
// 					dialog.dismiss();
// 			}
//
// 		});
// 		fourText.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(obj == null){
// 	 				String	dd = v.getResources().getString(four);
// 	 					listener.onItem4(dd);
// 	 				}else{
// 	 				listener.onItem4(obj);
// 	 				}
// 				if(dialog != null)
// 					dialog.dismiss();
// 			}
//
// 		});
//
// 		loadingDialog.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				if(dialog != null)
// 					dialog.dismiss();
//			}
//		});
//
// 		dialog.setContentView(loadingDialog);
//
//
// 		Window window = dialog.getWindow();
//
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int screenWidth = (int) (dm.widthPixels);
//
//
//
////		Log.i("test", "寮瑰嚭dialog鐨勯暱瀹�"+screenWidth);
//
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//
//
//		window.setAttributes(params0);
//		dialog.show();
// 		return dialog;
// 	}
//
//     public static Dialog AskForFriend(final Activity activity,final Object obj, final ConfirmDialog3ItemsListener listener,
//    		int title,int content1RsId, int content2RsId ,String hint,boolean maxLength,boolean show,boolean b_hint){
//
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 			mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
//
//		window.setAttributes(params0);
// 		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
// 		window.setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_HIDDEN
// 				| LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
// 		View loadingDialog = View.inflate(activity,R.layout.askforfrienddialog, null);
// 		RelativeLayout rl = (RelativeLayout) loadingDialog.findViewById(R.id.dialog_rl);
// 		TextView topClick = (TextView) loadingDialog.findViewById(R.id.left_text);
// 		TextView bottomClick = (TextView) loadingDialog.findViewById(R.id.right_text);
// 		TextView title1 = (TextView) loadingDialog.findViewById(R.id.textView1);
// 		TextView textView2 = (TextView) loadingDialog.findViewById(R.id.textView2);
// 		if(show)
// 			textView2.setVisibility(View.VISIBLE);
// 		else
// 			textView2.setVisibility(View.GONE);
// 		final EditText et = (EditText) loadingDialog.findViewById(R.id.askforfirend_content);
//
// 		if(b_hint)
// 			et.setHint(hint);
// 		else
// 			et.setText(hint);
// 		if(maxLength)
// 		{
// 			et.addTextChangedListener(COM.getTextWatcher(et, 20));
// 		}
// 		topClick.setText(content1RsId);
// 		bottomClick.setText(content2RsId);
// 		title1.setText(title);
// 		new Handler().postDelayed(new Runnable() {
//            public void run() {
//
//            	InputMethodManager imm = (InputMethodManager)et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        		imm.showSoftInput(et, InputMethodManager.RESULT_SHOWN);
//        		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
//            }
//            },500);
//
//
//
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
// 		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
// 		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
//// 		imgTop.setImageResource(icon1RsId);
//// 		imgBottom.setImageResource(icon2RsId);
//
// 		txtTop.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
// 				listener.onItem1(obj);
//
// 			}
//
// 		});
//
// 		txtBottom.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
// 				listener.onItem2(et.getText().toString());
//
// 			}
//
// 		});
//
// 		mDialogTwoButton.setContentView(loadingDialog);
//
//
// 		mDialogTwoButton.show();
// 		return mDialogTwoButton;
// 	}
//
//
//
//     public static Dialog DialogHozOneButton(final Activity activity,final Object obj, final ConfirmDialogListener listener,
//    		 int one){
//
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}
//
//		mDialogHozOneButton = new Dialog(activity,R.style.ThemeActivity);
//
//		mDialogHozOneButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//		View loadingDialog = View.inflate(activity,R.layout.dialog_hor_one, null);
//		View otherArea = loadingDialog.findViewById(R.id.layoutOneAll);
//
//		TextView topText = (TextView) loadingDialog.findViewById(R.id.textView1);
//
//		topText.setText(one);
//
//		topText.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				COM.LOGE(TAG, "DialogHozOneButton click");
//				listener.onOK(obj);
//				if(mDialogHozOneButton != null){
//					mDialogHozOneButton.dismiss();
//					mDialogHozOneButton = null;
//				}
//			}
//
//		});
//
//		otherArea.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				if(mDialogHozOneButton != null){
//					mDialogHozOneButton.dismiss();
//					mDialogHozOneButton = null;
//				}
//			}
//
//		});
//
//		mDialogHozOneButton.setContentView(loadingDialog);
//
//		Window window = mDialogHozOneButton.getWindow();
//
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int screenWidth = (int) (dm.widthPixels);
//
//
//
////		Log.i("test", "寮瑰嚭dialog鐨勯暱瀹�"+screenWidth);
//
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
////		params0.windowAnimations = android.R.anim.fade_in;
//
//
//		window.setAttributes(params0);
//
//		mDialogHozOneButton.show();
//		return mDialogHozOneButton;
//	}
//
//
//
//
//     public static void hideDialogHozSixButton(){
//    	 if(mDialogHozSixButton != null)
//    		 mDialogHozSixButton.dismiss();
//     }
//
//     public static Dialog DialogHozFiveButton(final Activity activity,final Object obj, final ConfirmDialog5ItemsListener listener,
//    		 int[] title){
//
// 		if(activity == null || title == null){
// 			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 		final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
// 		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
// 		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_5_items, null);
//
// 		TextView textView[] = new TextView[5];
//
// 		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
// 		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
// 		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
// 		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
// 		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
//
// 		for(int i=0; i<5; i++){
// 			textView[i].setText(title[i]);
// 		}
//
// 		loadingDialog.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				if(dialog != null)
//					dialog.dismiss();
//			}
//
// 		});
//
// 		textView[0].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem1(obj);
// 				if(dialog != null)
//					dialog.dismiss();
// 			}
//
// 		});
//
//
// 		textView[1].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem2(obj);
// 				if(dialog != null)
//					dialog.dismiss();
// 			}
//
// 		});
// 		textView[2].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem3(obj);
// 				if(dialog != null)
//					dialog.dismiss();
// 			}
//
// 		});
// 		textView[3].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem4(obj);
// 				if(dialog != null)
//					dialog.dismiss();
// 			}
//
// 		});
// 		textView[4].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem5(obj);
// 				if(dialog != null)
//					dialog.dismiss();
// 			}
//
// 		});
//
// 		dialog.setContentView(loadingDialog);
// 		Window window = dialog.getWindow();
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int screenWidth = (int) (dm.widthPixels);
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		window.setAttributes(params0);
//		dialog.show();
// 		return dialog;
// 	}
//
//     public static Dialog DialogHozSixButton(final Activity activity,final Object obj, final ConfirmDialog6ItemsListener listener,
//    		 int[] title){
//    	 if(activity == null || title == null){
//  			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//  		mDialogHozSixButton = new Dialog(activity,R.style.ThemeActivity);
//  		mDialogHozSixButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//  		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_6_items, null);
//
//  		TextView textView[] = new TextView[6];
//
//  		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
//  		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
//  		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
//  		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
//  		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
//  		textView[5] = (TextView) loadingDialog.findViewById(R.id.textView6);
//
//  		for(int i=0; i<6; i++){
//  			textView[i].setText(title[i]);
//  		}
//
//  		loadingDialog.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				hideDialogHozSixButton();
// 			}
//
//  		});
//
//  		textView[0].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem1(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//
//
//  		textView[1].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem2(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//  		textView[2].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem3(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//  		textView[3].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem4(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//  		textView[4].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem5(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//  		textView[5].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem6(obj);
//  				hideDialogHozSixButton();
//  			}
//
//  		});
//
//  		mDialogHozSixButton.setContentView(loadingDialog);
//  		Window window = mDialogHozSixButton.getWindow();
// 		DisplayMetrics dm = new DisplayMetrics();
// 		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
// 		int screenWidth = (int) (dm.widthPixels);
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		window.setAttributes(params0);
// 		mDialogHozSixButton.show();
//  		return mDialogHozSixButton;
//     }
//
//     public static Dialog DialogHozSevenButton(final Activity activity,final Object obj, final ConfirmDialog7ItemsListener listener,
//    		 int[] title){
//    	 if(activity == null || title == null){
//  			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//    	final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//  		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//  		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_7_items, null);
//
//  		TextView textView[] = new TextView[7];
//
//  		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
//  		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
//  		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
//  		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
//  		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
//  		textView[5] = (TextView) loadingDialog.findViewById(R.id.textView6);
//  		textView[6] = (TextView) loadingDialog.findViewById(R.id.textView7);
//
//  		for(int i=0; i<7; i++){
//  			textView[i].setText(title[i]);
//  		}
//
//  		loadingDialog.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
// 			}
//
//  		});
//
//  		textView[0].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem1(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//
//  		textView[1].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem2(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[2].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem3(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[3].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem4(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[4].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem5(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[5].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem6(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[6].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem7(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		dialog.setContentView(loadingDialog);
//  		Window window = dialog.getWindow();
// 		DisplayMetrics dm = new DisplayMetrics();
// 		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
// 		int screenWidth = (int) (dm.widthPixels);
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		window.setAttributes(params0);
// 		dialog.show();
//  		return dialog;
//     }
//
//     public static Dialog DialogHoz8Button(final Activity activity,final Object obj, final ConfirmDialog8ItemsListener listener,
//    		 int[] title){
//    	 if(activity == null || title == null){
//  			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//    	final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//  		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//  		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_8_items, null);
//
//  		TextView textView[] = new TextView[8];
//
//  		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
//  		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
//  		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
//  		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
//  		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
//  		textView[5] = (TextView) loadingDialog.findViewById(R.id.textView6);
//  		textView[6] = (TextView) loadingDialog.findViewById(R.id.textView7);
//  		textView[7] = (TextView) loadingDialog.findViewById(R.id.textView8);
//
//  		for(int i=0; i<8; i++){
//  			textView[i].setText(title[i]);
//  		}
//
//  		loadingDialog.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
// 			}
//
//  		});
//
//  		textView[0].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem1(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//
//  		textView[1].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem2(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[2].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem3(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[3].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem4(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[4].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem5(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[5].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem6(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[6].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem7(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[7].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem8(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		dialog.setContentView(loadingDialog);
//  		Window window = dialog.getWindow();
// 		DisplayMetrics dm = new DisplayMetrics();
// 		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
// 		int screenWidth = (int) (dm.widthPixels);
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		window.setAttributes(params0);
// 		dialog.show();
//  		return dialog;
//     }
//
//     public static Dialog DialogHoz9Button(final Activity activity,final Object obj, final ConfirmDialog9ItemsListener listener,
//    		 int[] title){
//    	 if(activity == null || title == null){
//  			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//    	final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//  		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//  		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_9_items, null);
//
//  		TextView textView[] = new TextView[9];
//
//  		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
//  		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
//  		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
//  		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
//  		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
//  		textView[5] = (TextView) loadingDialog.findViewById(R.id.textView6);
//  		textView[6] = (TextView) loadingDialog.findViewById(R.id.textView7);
//  		textView[7] = (TextView) loadingDialog.findViewById(R.id.textView8);
//  		textView[8] = (TextView) loadingDialog.findViewById(R.id.textView9);
//
//  		for(int i=0; i<9; i++){
//  			textView[i].setText(title[i]);
//  		}
//
//  		loadingDialog.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
// 			}
//
//  		});
//
//  		textView[0].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem1(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//
//  		textView[1].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem2(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[2].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem3(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[3].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem4(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[4].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem5(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//  		textView[5].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem6(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[6].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem7(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[7].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem8(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		textView[8].setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				listener.onItem9(obj);
//  				if(dialog != null && dialog.isShowing()){
//  					dialog.dismiss();
//  				}
//  			}
//
//  		});
//
//  		dialog.setContentView(loadingDialog);
//  		Window window = dialog.getWindow();
// 		DisplayMetrics dm = new DisplayMetrics();
// 		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
// 		int screenWidth = (int) (dm.widthPixels);
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		window.setAttributes(params0);
// 		dialog.show();
//  		return dialog;
//     }
//
//     public static Dialog DialogHozSixButton(final Activity activity,final Object obj, final ConfirmDialog6ItemsListener listener,
//    		 String[] title){
//
// 		if(activity == null || title == null){
// 			COM.LOGE("alertDialog", "ERR activity == null! title == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 		mDialogHozSixButton = new Dialog(activity,R.style.ThemeActivity);
// 		mDialogHozSixButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
// 		View loadingDialog = View.inflate(activity,R.layout.dialog_hoz_6_items, null);
//
// 		TextView textView[] = new TextView[6];
//
// 		textView[0] = (TextView) loadingDialog.findViewById(R.id.tadiary_share);
// 		textView[1] = (TextView) loadingDialog.findViewById(R.id.tadiary_shoucang);
// 		textView[2] = (TextView) loadingDialog.findViewById(R.id.tadiary_gift);
// 		textView[3] = (TextView) loadingDialog.findViewById(R.id.tadiary_report);
// 		textView[4] = (TextView) loadingDialog.findViewById(R.id.textView5);
// 		textView[5] = (TextView) loadingDialog.findViewById(R.id.textView6);
//
// 		for(int i=0; i<6; i++){
// 			textView[i].setText(title[i]);
// 		}
//
// 		loadingDialog.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				hideDialogHozSixButton();
//			}
//
// 		});
//
// 		textView[0].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem1(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
//
//
// 		textView[1].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem2(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
// 		textView[2].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem3(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
// 		textView[3].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem4(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
// 		textView[4].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem5(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
// 		textView[5].setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
// 				listener.onItem6(obj);
// 				hideDialogHozSixButton();
// 			}
//
// 		});
//
// 		mDialogHozSixButton.setContentView(loadingDialog);
// 		Window window = mDialogHozSixButton.getWindow();
//		DisplayMetrics dm = new DisplayMetrics();
//		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
//		int screenWidth = (int) (dm.widthPixels);
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		window.setAttributes(params0);
//		mDialogHozSixButton.show();
// 		return mDialogHozSixButton;
// 	}
//
//
//     public static Dialog DialogTwoButtonWithMsg(final Activity activity,final Object obj, final ConfirmDialogListener listener,
//    		 int titleid ,int msg1id, String msg2Str,int msg3id, int content1RsId, int content2RsId ){
//
//		if(activity == null){
//			COM.LOGE("alertDialog", "ERR activity == null!");
//			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//		}
//
//		final Dialog mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
////		params0.windowAnimations = android.R.anim.fade_in;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//		View loadingDialog = View.inflate(activity,R.layout.dialog_with_msg, null);
//		TextView leftClick = (TextView) loadingDialog.findViewById(R.id.left_text);
//		TextView rightClick = (TextView) loadingDialog.findViewById(R.id.right_text);
//		TextView title = (TextView) loadingDialog.findViewById(R.id.textView1);
//		TextView msg1 = (TextView) loadingDialog.findViewById(R.id.textViewMsg1);
//		TextView msg2 = (TextView) loadingDialog.findViewById(R.id.textViewMsg2);
//		TextView msg3 = (TextView) loadingDialog.findViewById(R.id.textViewMsg3);
//
//		leftClick.setText(content1RsId);
//		rightClick.setText(content2RsId);
//		if(titleid == 0)
//			title.setText("");
//		else
//			title.setText(titleid);
//
//		if(msg1id == 0)
//			msg1.setVisibility(View.GONE);
//		else
//			msg1.setText(msg1id);
//
//		msg2.setText(msg2Str);
//
//		if(msg3id == 0){
//			msg3.setVisibility(View.GONE);
//		}
//		else
//			msg3.setText(msg3id);
//
//
//		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
//		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
//		txtTop.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				listener.onCancel(obj);
//				if(mDialogTwoButton != null){
//		 			try{
//		 				mDialogTwoButton.dismiss();
//		 			}
//		 			catch(IllegalArgumentException e){
//		 				e.printStackTrace();
//		 			}
//		 		}
//			}
//
//		});
//
//		txtBottom.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//
//				listener.onOK(obj);
//				if(mDialogTwoButton != null){
//		 			try{
//		 				mDialogTwoButton.dismiss();
//		 			}
//		 			catch(IllegalArgumentException e){
//		 				e.printStackTrace();
//		 			}
//		 		}
//			}
//
//		});
//		mDialogTwoButton.setContentView(loadingDialog);
//
//
//
//		mDialogTwoButton.show();
//		return mDialogTwoButton;
//	}
//
//
//     public static Dialog shareConfirm(final BaseActivity activity,final String bid, final int hid,
//    		 final String imageUrl, String cText, String cAudio){
//
//  		if(activity == null){
//  			COM.LOGE("alertDialog", "ERR activity == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//  		final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//
//
// 		Window window = dialog.getWindow();
//
//
// 		int screenWidth =LayoutParams.FILL_PARENT;
// 		int screenHeight = LayoutParams.FILL_PARENT;
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		params0.height = screenHeight;
//
// 		window.setAttributes(params0);
// 		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//  		window.setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_HIDDEN
//  				| LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//
////  		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
//  		View loadingDialog = View.inflate(activity,R.layout.share_confirm_dialog, null);
//  		final EditText editText = (EditText) loadingDialog.findViewById(R.id.askforfirend_content);
//
//  		final int MAX_INPUT_LENGTH = 1500;
//
//  		editText.setFilters(new InputFilter[]{new InputFilter(){
//
//			@Override
//			public CharSequence filter(CharSequence source, int start, int end,
//					Spanned dest, int dstart, int dend) {
////				COM.LOGE("","source:"+source+" start:"+start+" end:"+end+" dest:"+dest
////						+" dstart:"+dstart+" dend:"+dend);
//
//				if(dest != null && source != null){
//					String str = dest.toString();
//					String strSource = source.toString();
//					if(str != null && strSource != null){
//						int length;
//						int lengthSource;
//						try {
//							length = str.getBytes("GBK").length;
//							lengthSource = strSource.getBytes("GBK").length;
////							COM.LOGE("","length:"+length);
//							if(length+lengthSource > MAX_INPUT_LENGTH){
//								int lengthMore = (length+lengthSource)-MAX_INPUT_LENGTH;
//								lengthSource -= lengthMore;
//
//								String strEnter = COM.strcut(strSource,lengthSource);
////								COM.LOGE("","strEnter:"+strEnter);
//								return strEnter;
//							}
//						} catch (UnsupportedEncodingException e) {
////							COM.LOGE("","UnsupportedEncodingException e");
//							e.printStackTrace();
//						}
//					}
//					else{
//						COM.LOGE("","str != null");
//					}
//				}
//				return null;
//
//			}
//
//		}});
//
//  		final ImageView imageShareIcon = (ImageView) loadingDialog.findViewById(R.id.share_icon);
//  		TextView content = (TextView) loadingDialog.findViewById(R.id.shareContent);
//
//  		final DownloadListener mDownloadListener = new DownloadListener(){
//
//			@Override
//			public void onFinish(String url, byte[] data) {
//				activity.runOnUiThread(new Runnable(){
//
//					@Override
//					public void run() {
//
//						BitmapCache.SetImageView(imageShareIcon, R.drawable.default_po_imgthumb, imageUrl+"_s", new DownloadListener(){
//
//							@Override
//							public void onFinish(String url, byte[] data) {
//								// TODO Auto-generated method stub
//								COM.LOGE("", "shareConfirm never here!");
//							}
//
//							@Override
//							public void onError(String url, Exception e) {
//								// TODO Auto-generated method stub
//
//							}
//
//						});
//					}
//
//				});
//			}
//
//			@Override
//			public void onError(String url, Exception e) {
//				// TODO Auto-generated method stub
//
//			}
//
//  		};
//
//  		if(imageUrl != null && !imageUrl.equals("")){
//  			String cacheSmallPath = BitmapCache.getFileInSDPath(imageUrl);
//  			File file = new File(cacheSmallPath+"_s");
//  			if(file != null && file.exists()){
//  				BitmapCache.SetImageView(imageShareIcon, R.drawable.default_po_imgthumb, imageUrl+"_s", mDownloadListener);
//  			}
//  			else{
//  				file = new File(cacheSmallPath+"_m");//鑻ユ湁middle澶у皬鍥剧墖锛屽垯浼樺厛鏄剧ず_m鍥剧墖锛屽惁鍒欐樉绀篲s.
//  	  			if(file != null && file.exists()){
//  	  				BitmapCache.SetImageView(imageShareIcon, R.drawable.default_po_imgthumb, imageUrl+"_m", mDownloadListener);
//  	  			}
//  	  			else{
//  	  				BitmapCache.SetImageView(imageShareIcon, R.drawable.default_po_imgthumb, imageUrl+"_s", mDownloadListener);
//  	  			}
//  			}
//
//  		}
//  		else if(cAudio != null && !cAudio.equals("")){
//  			imageShareIcon.setImageResource(R.drawable.sharedpo_audio);
//  		}
//  		else{
//  			imageShareIcon.setVisibility(View.GONE);
//  		}
//
//  		if(cText != null){
//  			content.setText(cText);
//  		}
////  		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
//  		LinearLayout txtLeft = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
//  		LinearLayout txtRight = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
////  		imgTop.setImageResource(icon1RsId);
////  		imgBottom.setImageResource(icon2RsId);
//
//  		txtLeft.setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//  				if(dialog != null)
//  					dialog.dismiss();
//  			}
//
//  		});
//
//  		txtRight.setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				GeneralAccesser accesser = new GeneralAccesser(false);
//  				accesser.addObserver(activity);
//  				HashMap<String,String> params = new HashMap<String,String>();
//  				if(hid > 0){
//  					params.put("hid", hid+"");
//  				}
//  				else{
//  					params.put("bid", bid);
//  				}
//  				params.put("c_text", editText.getText().toString());
//
//  				accesser.start(COM.SHARE_BLOG_URL, params);
//
//  				InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//				imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//
////  				listener.onOK(et.getText().toString());
//  				if(dialog != null)
//  					dialog.dismiss();
//
//  			}
//
//  		});
//
//  		dialog.setContentView(loadingDialog);
//
//  		new Handler().postDelayed(new Runnable() {
//            public void run() {
//
//            	InputMethodManager imm = (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        		imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
//        		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
//            }
//            },200);
//
//
//  		dialog.show();
//  		return dialog;
//  	}
//
//
//     public static Dialog newVesrionConfirm(final Activity activity,final Settings settings,final String version,final String versionInfo, final String url){
//
//  		if(activity == null){
//  			COM.LOGE("alertDialog", "ERR activity == null!");
//  			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
//  		}
//
//  		final Dialog dialog = new Dialog(activity,R.style.ThemeActivity);
//
//
// 		Window window = dialog.getWindow();
//
//
// 		int screenWidth =LayoutParams.FILL_PARENT;
// 		int screenHeight = LayoutParams.FILL_PARENT;
// 		LayoutParams params0 = window.getAttributes();
// 		params0.width = screenWidth;
// 		params0.height = screenHeight;
//
// 		window.setAttributes(params0);
// 		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
////  		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
//  		View loadingDialog = View.inflate(activity,R.layout.newversion_confirm_dialog, null);
//
//
//  		TextView content = (TextView) loadingDialog.findViewById(R.id.versionMsg);
//  		TextView versionMsgInfo = (TextView) loadingDialog.findViewById(R.id.versionMsgInfo);
//
//  		if(content != null){
//  			String info = String.format(activity.getString(R.string.newversion_info1),version);
//  			content.setText(info);
//  		}
//
//  		if(content != null){
//  			String info = String.format(activity.getString(R.string.newversion_info1),version);
//  			content.setText(info);
//  		}
//
//  		if(versionInfo != null && !versionInfo.equals("")){
//  			versionMsgInfo.setText(versionInfo);
//  		}
//  		else{
//  			versionMsgInfo.setVisibility(View.GONE);
//  		}
////  		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
//  		LinearLayout txtLeft = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
//  		LinearLayout txtRight = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
////  		imgTop.setImageResource(icon1RsId);
////  		imgBottom.setImageResource(icon2RsId);
//
//  		txtLeft.setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//  				settings.putLong(Settings.KEY_NEW_VERSION_LAST_INFORM_TIME, System.currentTimeMillis());
//  				if(dialog != null)
//  					dialog.dismiss();
//  			}
//  		});
//
//  		txtRight.setOnClickListener(new OnClickListener(){
//
//  			@Override
//  			public void onClick(View v) {
//
//  				if(url != null ){ //&& url.startsWith("http:")
//					Uri uri = Uri.parse(url); //url涓轰綘瑕侀摼鎺ョ殑鍦板潃
//                    Intent intent =new Intent(Intent.ACTION_VIEW, uri);
//                    activity.startActivity(intent);
//				}
//  				if(dialog != null)
//  					dialog.dismiss();
//
//  			}
//
//  		});
//
//  		dialog.setOnDismissListener(new OnDismissListener() {
//			@Override
//			public void onDismiss(DialogInterface arg0) {
//
//			}
//		});
//
//  		dialog.setContentView(loadingDialog);
//
//
//
//
//  		dialog.show();
//  		return dialog;
//  	}
//
//     public static Dialog RemaindDialog(final Activity activity,boolean showMsg){
//
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 		final Dialog mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
////		params0.windowAnimations = android.R.anim.fade_in;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
// 		View loadingDialog = View.inflate(activity,R.layout.remainddialog, null);
// 		TextView leftClick = (TextView) loadingDialog.findViewById(R.id.left_text);
// 		TextView rightClick = (TextView) loadingDialog.findViewById(R.id.right_text);
//// 		TextView title = (TextView) loadingDialog.findViewById(R.id.textView1);
//// 		TextView msg1 = (TextView) loadingDialog.findViewById(R.id.textViewMsg1);
//// 		TextView msg2 = (TextView) loadingDialog.findViewById(R.id.textViewMsg2);
// 		TextView msg3 = (TextView) loadingDialog.findViewById(R.id.textViewMsg3);
//
// 	    UserSetting mUserSetting = SQLiteHelper.getInstance(activity).getUserSetting(MyApp.getInstance().getUid());
//		if(mUserSetting == null){
//			mUserSetting = new UserSetting();
//		}
// 		final int radioButtonId = mUserSetting.fw_temp_chat;
//
//// 		int radioButtonId = Settings.getInstance().getInt(Settings.KEY_TEMP_GROUP_SETTING, 0);
// 		final RadioGroup group = (RadioGroup) loadingDialog.findViewById(R.id.radioGroup1);
//
// 		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
// 		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//		// 缁戝畾涓�涓尶鍚嶇洃鍚櫒
//		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//
//			@Override
//			public void onCheckedChanged(RadioGroup arg0, int arg1) {
//				// TODO Auto-generated method stub
//				// 鑾峰彇鍙樻洿鍚庣殑閫変腑椤圭殑ID
////				 radioButtonId = arg0.getCheckedRadioButtonId();
////				int uid = MyApp.getInstance().getUid();
////				SQLiteHelper mSQLiteHelper = SQLiteHelper.getInstance(activity);
////				  UserSetting mUserSetting = mSQLiteHelper.getUserSetting(uid);
////					if(mUserSetting == null){
////						mUserSetting = new UserSetting();
////					}
////				 switch(group.getCheckedRadioButtonId()){
////	 				case R.id.radio0:
////	 					mUserSetting.fw_temp_chat = 1;
//////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 0);
////	 					break;
////	 				case R.id.radio1:
////	 					mUserSetting.fw_temp_chat = 2;
//////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 1);
////	 					break;
////	 				case R.id.radio2:
////	 					mUserSetting.fw_temp_chat = 3;
//////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 2);
////	 					break;
////	 				case R.id.radio3:
////	 					mUserSetting.fw_temp_chat = 4;
//////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 3);
////	 					break;
////	 			}
//
////				 mSQLiteHelper.updateUserSetting(mUserSetting, uid);
////				COM.LOGI("鐐瑰嚮浜嗗摢涓猺adio", ""+radioButtonId+ "浣嶇疆 "+ arg1);
////				// 鏍规嵁ID鑾峰彇RadioButton鐨勫疄渚�
////				rb = (RadioButton)mContext.findViewById(radioButtonId);
//
//			}
//		});
//// 		leftClick.setText(content1RsId);
//// 		rightClick.setText(content2RsId);
//// 		if(titleid == 0)
//// 			title.setText("");
//// 		else
//// 			title.setText(titleid);
////
//// 		if(msg1id == 0)
//// 			msg1.setVisibility(View.GONE);
//// 		else
//// 			msg1.setText(msg1id);
////
//// 		msg2.setText(msg2Str);
//
// 		if(showMsg){
// 			msg3.setVisibility(View.VISIBLE);
// 		}
// 		else
// 			msg3.setVisibility(View.GONE);
//
// 		switch(radioButtonId){
// 		case 1:
// 			group.check(R.id.radio0);
// 			break;
// 		case 2:
// 			group.check(R.id.radio1);
// 			break;
// 		case 3:
// 			group.check(R.id.radio2);
// 			break;
// 		case 4:
// 			group.check(R.id.radio3);
// 			break;
// 		}
//
//
// 		txtTop.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
//// 				listener.onCancel(obj);
// 				if(mDialogTwoButton != null){
// 		 			try{
// 		 				mDialogTwoButton.dismiss();
// 		 			}
// 		 			catch(IllegalArgumentException e){
// 		 				e.printStackTrace();
// 		 			}
// 		 		}
// 			}
//
// 		});
//
// 		txtBottom.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
//
//// 				listener.onOK(obj);
// 				SQLiteHelper sqlite = SQLiteHelper.getInstance(activity);
// 				if(sqlite == null)
// 					return;
// 				int myUid = sqlite.mMyUid;
// 				  UserSetting mUserSetting = sqlite.getUserSetting(myUid);
// 					if(mUserSetting == null){
// 						mUserSetting = new UserSetting();
// 					}
//
// 					int id = 1;
// 					switch(group.getCheckedRadioButtonId()){
//	 				case R.id.radio0:
//	 					id = 1;
////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 0);
//	 					break;
//	 				case R.id.radio1:
//	 					id = 2;
////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 1);
//	 					break;
//	 				case R.id.radio2:
//	 					id = 3;
////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 2);
//	 					break;
//	 				case R.id.radio3:
//	 					id = 4;
////	 					Settings.getInstance().putInt(Settings.KEY_TEMP_GROUP_SETTING, 3);
//	 					break;
//	 			}
//
// 			 		if(id != mUserSetting.fw_temp_chat){
// 			 			mUserSetting.fw_temp_chat = id;
// 			 			sqlite.updateUserSetting(mUserSetting, myUid);
//		 				SettingsPrivacyAccesser accesser = new SettingsPrivacyAccesser(false);
//						accesser.startSetPrivacyMain(id);
// 			 		}
// 			 		if(activity instanceof SettingsPushSetActivity){
// 			 			SettingsPushSetActivity act = (SettingsPushSetActivity)activity;
// 			 			act.setRejectItem(id-1,false);
// 			 		}
// 			 		ToastAPI.showShort(activity, R.string.set_ok);
// 				if(mDialogTwoButton != null){
// 		 			try{
// 		 				mDialogTwoButton.dismiss();
// 		 			}
// 		 			catch(IllegalArgumentException e){
// 		 				e.printStackTrace();
// 		 			}
// 		 		}
// 			}
//
// 		});
// 		mDialogTwoButton.setContentView(loadingDialog);
//
//
//
// 		mDialogTwoButton.show();
// 		return mDialogTwoButton;
// 	}
//
//     /**obj 浼爂id*/
//
//     public static Dialog GroupMemberControlDialog(final Activity activity,final int gid,final Context context){
//
//
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
//
// 		mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
//
//
//		Window window = mDialogTwoButton.getWindow();
//
//
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
////		params0.windowAnimations = android.R.anim.fade_in;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//
//// 		View loadingDialog = View.inflate(activity,R.layout.confirm_dialog, null);
// 		View loadingDialog = View.inflate(activity,R.layout.group_member_control_dialog_layout, null);
// 		RelativeLayout rl = (RelativeLayout) loadingDialog.findViewById(R.id.dialog_rl);
//// 		TextView topClick = (TextView) loadingDialog.findViewById(R.id.left_text);
//// 		TextView bottomClick = (TextView) loadingDialog.findViewById(R.id.right_text);
//// 		TextView title = (TextView) loadingDialog.findViewById(R.id.textView1);
//// 		TextView msg = (TextView) loadingDialog.findViewById(R.id.textView2);
//// 		topClick.setText(content1RsId);
//// 		bottomClick.setText(content2RsId);
//// 		title.setText(titleid);
//// 		msg.setText(msgid);
//// 		ImageView imgTop = (ImageView) loadingDialog.findViewById(R.id.imageView1);
//// 		ImageView imgBottom = (ImageView) loadingDialog.findViewById(R.id.imageView2);
//
// 		LinearLayout txtTop = (LinearLayout)loadingDialog.findViewById(R.id.left_btn);
// 		LinearLayout txtBottom = (LinearLayout)loadingDialog.findViewById(R.id.right_btn);
//
//// 		imgTop.setImageResource(icon1RsId);
//// 		imgBottom.setImageResource(icon2RsId);
//
// 		txtTop.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
//
// 				hideDialogTwoButton();
// 			}
//
// 		});
//
// 		txtBottom.setOnClickListener(new OnClickListener(){
//
// 			@Override
// 			public void onClick(View v) {
//
// 				GroupInfoActivity.startActivity(context, gid);
// 				hideDialogTwoButton();
// 			}
//
// 		});
// 		rl.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
////				listener.onItem3(obj);
////				hideDialogHozTwoButton();
//			}
//
// 		});
// 		mDialogTwoButton.setContentView(loadingDialog);
//
//
//
// 		mDialogTwoButton.show();
// 		return mDialogTwoButton;
// 	}
     
     
//     public static Dialog ShareToOtherAPP(final Activity activity,final Object obj){
// 		
// 		if(activity == null){
// 			COM.LOGE("alertDialog", "ERR activity == null!");
// 			return null;//(new Dialog(activity,R.style.CustomDialogStyle));
// 		}
// 		  SendMSGToWX sendMsg = new SendMSGToWX(activity);
// 	        sendMsg.register();
// 		mDialogTwoButton = new Dialog(activity,R.style.ThemeActivity);
// 		
//
//		Window window = mDialogTwoButton.getWindow();
//		
//		
//		int screenWidth =LayoutParams.FILL_PARENT;
//		int screenHeight = LayoutParams.FILL_PARENT;
//		WindowManager.LayoutParams params0 = window.getAttributes();
//		params0.width = screenWidth;
//		params0.height = screenHeight;
//		window.setAttributes(params0);
//		mDialogTwoButton.requestWindowFeature(Window.FEATURE_NO_TITLE);
// 		View loadingDialog = View.inflate(activity,R.layout.share_to_other_app, null);
// 		
// 		loadingDialog.findViewById(R.id.wechat).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				if(obj != null)
//				{
//					if(obj instanceof ShareStruct){
//						ShareStruct temp = (ShareStruct)obj;
//						switch(temp.type){
//						case ShareStruct.TYPE_WEB:
//							SendMSGToWX sendMsg = new SendMSGToWX(activity);
//							sendMsg.sendWebMSG(temp.webUrl, temp.title, temp.description, temp.imgUrl, false);
//							mDialogTwoButton.hide();
//						break;
//						default:
//							break;
//						}
//					}
//				}
//			}
//		});
// 		
// 		loadingDialog.findViewById(R.id.friends).setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
// 		
// 		mDialogTwoButton.setContentView(loadingDialog);
// 		
// 		mDialogTwoButton.show();
// 		
// 		return mDialogTwoButton;
// 	}
}

