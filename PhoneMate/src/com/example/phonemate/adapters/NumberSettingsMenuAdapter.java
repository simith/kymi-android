package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;
import com.enterpriseapps.kymi.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberSettingsMenuAdapter extends BaseAdapter {

	 private List<PhoneMenuItem> menuList;
	 private final Context context;
	 
	 public static  final int PM_ITEM_MY_SETTINGS = 1;
	 public static final int PM_ITEM_VOICE_MENU= 2;
	 public static  final int PM_ITEM_CALL_LOGS = 3;
	 public static  final int PM_ITEM_VOICEMAIL = 4;

	  
	
	public NumberSettingsMenuAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<PhoneMenuItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
		menuList.add(new PhoneMenuItem("Settings", R.drawable.action_settings,PM_ITEM_MY_SETTINGS));
		menuList.add(new PhoneMenuItem("Voice Menu",R.drawable.menu,PM_ITEM_VOICE_MENU ));
		menuList.add(new PhoneMenuItem("Call Logs", R.drawable.device_access_call,PM_ITEM_CALL_LOGS));
		menuList.add(new PhoneMenuItem("Recordings",R.drawable.content_email,PM_ITEM_VOICEMAIL));
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuList.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return menuList.get(pos);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup parent) {
		ImageView iconView = null;
		TextView titleView = null;
		View rowView = null;
		
		if(view == null){
		
		 LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		 
		 
		}
		else
		{
		  rowView = view;	
		}
		
		iconView = (ImageView) rowView.findViewById(R.id.icon);
		titleView = (TextView) rowView.findViewById(R.id.title);
		
		iconView.setImageResource(menuList.get(arg0).getResId());
		titleView.setText(menuList.get(arg0).getName());
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(PhoneMenuItem p){
	
		menuList.add(p);
	}
	
	

}
