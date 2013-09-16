package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.data.types.IncomingPhoneNumberItem;
import com.example.phonemate.data.types.PhoneNumberItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPhoneNumbersListItemAdapter extends BaseAdapter {

	 private List<IncomingPhoneNumberItem> menuList;
	 private final Context context;
	 
		
	public MyPhoneNumbersListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<IncomingPhoneNumberItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
		//menuList.add(new PhoneMenuItem("03234566", R.drawable.device_access_call,0));
		
	
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
		
		iconView.setImageResource(R.drawable.device_access_call);
		titleView.setText(menuList.get(arg0).getPhoneNumber() + " ("+menuList.get(arg0).getMode() + ")");
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(IncomingPhoneNumberItem p){
	
		menuList.add(p);
	}
	
public void clearResults(){
		
		clear();
		notifyDataSetChanged();
	}
	
	public int updateSearchResults(List<IncomingPhoneNumberItem> pResults){
		
		int numberOfItems = 0;
		
		menuList.clear();
		menuList.addAll(pResults);
		notifyDataSetChanged();
		
		return pResults.size();
	}
	
	

}
