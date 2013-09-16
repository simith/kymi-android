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

public class AppMainMenuListItemAdapter extends BaseAdapter {

	 private List<PhoneMenuItem> menuList;
	 private final Context context;
	 
	 public static final int PM_ITEM_BUY_A_NUMBER = 0;
	 public static final int PM_ITEM_MY_NUMBERS = 1;
	 public static  final int PM_ITEM_VOICEMAIL = 2;
	 public static  final int PM_ITEM_MY_MENU = 3;
	 public static  final int PM_ITEM_MY_SETTINGS = 4;
	 
	 
	
	public AppMainMenuListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<PhoneMenuItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
		menuList.add(new PhoneMenuItem("Buy a number", R.drawable.action_search,PM_ITEM_BUY_A_NUMBER));
		menuList.add(new PhoneMenuItem("My Numbers",R.drawable.device_access_call,PM_ITEM_MY_NUMBERS ));
		menuList.add(new PhoneMenuItem("Voicemail", R.drawable.av_play,PM_ITEM_VOICEMAIL));
		//menuList.add(new PhoneMenuItem("My Menu",R.drawable.menu,PM_ITEM_MY_MENU));
		menuList.add(new PhoneMenuItem("My Settings",R.drawable.menu,PM_ITEM_MY_SETTINGS));
	
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
