package com.hzg.wuri;

import java.util.ArrayList;

import android.content.Context;

public class DataUtils {
	ArrayList<Data> mList = new ArrayList<Data>();
	static DataUtils mInstance;
	Context mContext;
	String wuriStr;
	public static DataUtils getInstance(Context context){
		if(mInstance == null)
			mInstance = new DataUtils(context);
		return mInstance;
	}
	
	public DataUtils(Context context){
		mContext = context;
		wuriStr = context.getResources().getString(R.string.wuri);
		if(mList == null || mList.size() == 0){
			mList = getList();
		}
	}
	
	public ArrayList<Data> getWuRiList(){
		if(mList == null || mList.size() == 0){
			return getList();
		}
		else{
			return mList;
		}
	}
	
	private ArrayList<Data> getList(){
		ArrayList<Data> list = new ArrayList<Data>();
		String[] wuriArray = mContext.getResources().getStringArray(R.array.wuri);
		if(wuriArray != null && wuriArray.length > 0){
//			int len = wuriStr.length;
			String [] temp;
			Data data;
			for(String str : wuriArray){
				if(str != null){
					temp = str.split("\\|");
					if(temp != null && temp.length>=2){
						data = new Data();
						data.month = COM.getInt(temp[0]);
						data.day = COM.getInt(temp[1]);
						data.info = (temp.length) >=3 ? temp[2] : this.wuriStr;
						list.add(data);
					}
				}
			}
		}
		return list;
	}
	
	public Data getWuRiData(Data data){
		boolean isFind = false;
		for(Data temp : mList){
			if(temp.month == data.month && temp.day == data.day){
				if(temp.info != null && !temp.equals("")){
					data.info += temp.info;
				}
				else{
					data.info += wuriStr;
					
				}
				isFind = true;
				break;
			}
		}
		
		if(isFind)
			return data;
		else
			return null;
	}
	
	public Data getTodayWuRiData(){
		Data data = COM.getTodayData(mContext);
		boolean isFind = false;
		for(Data temp : mList){
			if(temp.month == data.month && temp.day == data.day){
				if(temp.info != null && !temp.equals("")){
					data.info += temp.info;
					isFind = true;
					break;
				}
				else{
					data.info += wuriStr;
					isFind = true;
					break;
				}
			}
		}
		
		if(isFind)
			return data;
		else
			return null;
	}
	
}
