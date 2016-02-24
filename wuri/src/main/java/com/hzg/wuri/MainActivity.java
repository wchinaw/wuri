package com.hzg.wuri;

import java.util.ArrayList;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	MainActivity mContext;
	TextView textTitle;
	ListView mListView;
	WuRiAdapter mAdapter;
	ArrayList<Data> mWuRiList;
	DataUtils mDataUtils;
	String strToday,strNoAlarm;
	
	Data todayData;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        strToday = getResources().getString(R.string.today);
        strNoAlarm = getResources().getString(R.string.no_alarm);
        
        this.setTitle(R.string.wuri_title);
        
        textTitle = (TextView) findViewById(R.id.textTitle);
        mListView = (ListView) findViewById(R.id.listView1);
        mDataUtils = DataUtils.getInstance(this);
        mWuRiList = mDataUtils.getWuRiList();
        mAdapter = new WuRiAdapter();
        mListView.setAdapter(mAdapter);
        
        mListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				if(pos >=0 && pos <mWuRiList.size()){
					Data data = mWuRiList.get(pos);
					if(data != null)
						COM.copy(mContext, data.month+"-"+data.day+" "+data.info);
				}
				return true;
			}
		});
        Intent intent = new Intent(this,WuRiService.class);
        startService(intent);
        
        Settings mSettings = Settings.getInstance();
        
        if(!mSettings.getBoolean(Settings.KEY_APP_IS_CREATE_SHORTCUT)){
//          ShortCut.hasShortcut(this);
              ShortCut.creatShortCut(this);
              mSettings.putBoolean(Settings.KEY_APP_IS_CREATE_SHORTCUT, true);
          }
        
        intent = new Intent(COM.BROADCAST_SET_NOTIFICATION_SHOWED);
        sendBroadcast(intent);
        
        MobclickAgent.updateOnlineConfig( mContext );
        UmengUpdateAgent.update(this);
    }
    
    
    
    @Override
	protected void onResume() {
    	todayData = COM.getTodayData(this);
        setCurrentSelection(todayData);
        Data data = mDataUtils.getWuRiData(todayData);
        if(data != null){
        	textTitle.setText(data.month+"-"+data.day+" "+data.info);
        	Toast.makeText(this, data.info, Toast.LENGTH_SHORT).show();
        }
        else{
//        	textTitle.setVisibility(View.GONE);
        	textTitle.setText(strToday+" "+todayData.month+"-"+todayData.day+" "+strNoAlarm);
        }
		super.onResume();
		MobclickAgent.onResume(this);
	}
    
    public void onPause() {
    	super.onPause();
    	MobclickAgent.onPause(this);
    }

    
    public void titleClick(View v){
    	setCurrentSelection(todayData);
    }


	public void webClick(View v){
		Intent intent= new Intent();
		intent.setAction("android.intent.action.VIEW");
		Uri content_url = Uri.parse("http://www.hnhzg.com/m/");
		intent.setData(content_url);
		startActivity(intent);
	}

	public void setCurrentSelection(Data today){
		if(today == null)
			return;
    	int len = mWuRiList.size();
    	Data data;
    	for(int i=0; i<len; i++){
    		data = mWuRiList.get(i);
    		if(data.month >= today.month && data.day >= today.day){
    			mListView.setSelection(i);
    			break;
    		}
    	}
    }
    
    public class WuRiAdapter extends BaseAdapter{
    	LayoutInflater mInflater; 
    	public WuRiAdapter(){
        	mInflater = LayoutInflater.from(mContext);
    	}
    	
		@Override
		public int getCount() {
			if(mWuRiList == null)
				return 0;
			else
				return mWuRiList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int pos, View view, ViewGroup arg2) {
			ViewHolder holder;
			if(view == null){
				holder = new ViewHolder();
				view = mInflater.inflate(R.layout.list_item, null);
				holder.info = (TextView) view.findViewById(R.id.textView1);
				view.setTag(holder);
			}
			else{
				holder = (ViewHolder) view.getTag();
			}
			Data data = mWuRiList.get(pos);
			holder.info.setText(data.month+"-"+data.day+" "+data.info);
			
			return view;
		}
		
    	class ViewHolder{
    		TextView info;
    	}
    }
    
}
