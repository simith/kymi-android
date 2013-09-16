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
import android.widget.Spinner;
import android.widget.TextView;

public class PostPhoneMenuListItemAdapter extends BaseAdapter {

	 private List<PhoneMenuItem> menuList;
	 private final Context context;
	 
	 /*dont change the order, spinner uses this for positioning items*/
	 public static  final int PM_POST_MENU_MAIN_MENU = 0;
	 public static final int PM_POST_MENU_DIAL_OUT = 1;
	 public static final int PM_POST_MENU_RECORD_MSG = 2;
	 
	 String text="{\"menuItems\":[{\"action\":\"dial-out\",\"welcomeMsg\":\"\",\"shortMsg\":\"Salesman\",\"digit\":1},{\"action\":\"menu\",\"welcomeMsg\":\"\",\"shortMsg\":\"Fon\",\"digit\":2},{\"action\":\"menu\",\"welcomeMsg\":\"\",\"shortMsg\":\"Shop timings\",\"digit\":3},{\"action\":\"dial-out\",\"welcomeMsg\":\"\",\"shortMsg\":\"Gorillas\",\"digit\":4},{\"action\":\"menu\",\"welcomeMsg\":\"\",\"shortMsg\":\"Contacts\",\"digit\":5}],\"welcomeMessage\":{\"msg\":\"Welcome to my company\"}}";
	

	 
	 
	
	public PostPhoneMenuListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<PhoneMenuItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
	  menuList.add(new PhoneMenuItem("Back to Main Menu", R.drawable.navigation_back,PM_POST_MENU_MAIN_MENU));	
	  menuList.add(new PhoneMenuItem("Dial out", R.drawable.device_access_call,PM_POST_MENU_DIAL_OUT));
	  menuList.add(new PhoneMenuItem("Record a Message",R.drawable.content_email,PM_POST_MENU_RECORD_MSG ));
	 
		
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
		 rowView = inflater.inflate(R.layout.post_menu_option, parent, false);
		 
		 
		}
		else
		{
		  rowView = view;	
		}
		
		iconView = (ImageView) rowView.findViewById(R.id.optionImg);
		titleView = (TextView) rowView.findViewById(R.id.optionTxt);
		
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
	
	public int getSpinnerPosition(String pAction){
		
		int actionInt = 0;
		
		if(pAction == null)
			return actionInt;
		
		if(pAction.equals("menu")){
			
			actionInt = PM_POST_MENU_MAIN_MENU;
		}
		else if(pAction.equals("dial-out")){
			
			actionInt = PM_POST_MENU_DIAL_OUT;
		}
		else if(pAction.equals("record")){
			
			actionInt = PM_POST_MENU_RECORD_MSG;
		}
		
		return actionInt;
		
		
	}
	
	

}
