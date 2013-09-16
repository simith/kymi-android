package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.example.phonemate.resources.ResourceManager;

public class PhoneNumbersListItemAdapter extends BaseAdapter {

	 private List<PhoneNumberItem> menuList;
	 private final Context context;
	 String TAG = "ERROR";
	
	public PhoneNumbersListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<PhoneNumberItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
		
		/*menuList.add(new PhoneMenuItem("03452123", R.drawable.device_access_call, 0));
		menuList.add(new PhoneMenuItem("03452123", R.drawable.device_access_call, 0));
		menuList.add(new PhoneMenuItem("03452123", R.drawable.device_access_call, 0));
		menuList.add(new PhoneMenuItem("03452123", R.drawable.device_access_call, 0));*/
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return menuList.get(arg0);
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
		
		iconView.setImageResource(ResourceManager.getCountryFlag(menuList.get(arg0).getCountry_code()));
		titleView.setText(menuList.get(arg0).getNumber());
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(PhoneNumberItem p){
	
		menuList.add(p);
	}
	
	public void clearResults(){
		
		clear();
		notifyDataSetChanged();
	}
	
	public int updateSearchResults(List<PhoneNumberItem> pResults){
		
		int numberOfItems = 0;
		
		menuList.clear();
		menuList.addAll(pResults);
		notifyDataSetChanged();
		
		return pResults.size();
	}
	
	// adds new results
	public void addNewResults(List<PhoneNumberItem> pResults){
		
		
		
	}
	
	
}
