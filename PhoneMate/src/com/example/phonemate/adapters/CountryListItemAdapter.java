package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.data.types.CountryListItem;
import com.example.phonemate.resources.countries.CountryCode;

public class CountryListItemAdapter implements SpinnerAdapter {

	 private List<CountryListItem> menuList;
	 private final Context context;
	
	public CountryListItemAdapter(Context ctxt) {
		
		menuList = new LinkedList<CountryListItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
		menuList.add(new CountryListItem("Australia",CountryCode.AU,R.drawable.au));
		menuList.add(new CountryListItem("Austria", CountryCode.AT, R.drawable.at));
		menuList.add(new CountryListItem("Belgium", CountryCode.BE, R.drawable.be));
		menuList.add(new CountryListItem("Canada", CountryCode.CA, R.drawable.ca));
		menuList.add(new CountryListItem("United Kingdom", CountryCode.GB, R.drawable.gb));
		menuList.add(new CountryListItem("Finland", CountryCode.FI, R.drawable.fi));
		menuList.add(new CountryListItem("France", CountryCode.FR, R.drawable.fr));
		menuList.add(new CountryListItem("Hong Kong", CountryCode.HK, R.drawable.hk));
		menuList.add(new CountryListItem("Ireland", CountryCode.IE, R.drawable.ie));
		menuList.add(new CountryListItem("Israel", CountryCode.IL, R.drawable.il));
		menuList.add(new CountryListItem("Italy", CountryCode.IT, R.drawable.it));
		menuList.add(new CountryListItem("Japan", CountryCode.JP, R.drawable.jp));
		menuList.add(new CountryListItem("New Zealand", CountryCode.NZ, R.drawable.nz));
		menuList.add(new CountryListItem("Spain", CountryCode.ES, R.drawable.es));
		menuList.add(new CountryListItem("United Kingdom", CountryCode.GB, R.drawable.gb));
		menuList.add(new CountryListItem("USA", CountryCode.US, R.drawable.us));
		
		
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
		 rowView = inflater.inflate(R.layout.country_row_layout, parent, false);
		 
		 
		}
		else
		{
		  rowView = view;	
		}
		
		iconView = (ImageView) rowView.findViewById(R.id.country_flag);
		titleView = (TextView) rowView.findViewById(R.id.title);
		
		iconView.setImageResource(menuList.get(arg0).getResId());
		titleView.setText(menuList.get(arg0).getCountry());
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(CountryListItem p){
	
		menuList.add(p);
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		ImageView iconView = null;
		TextView titleView = null;
		View rowView = null;
		
		if(convertView == null){
		
		 LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 rowView = inflater.inflate(R.layout.country_row_layout, parent, false);
		 
		 
		}
		else
		{
		  rowView = convertView;	
		}
		
		iconView = (ImageView) rowView.findViewById(R.id.country_flag);
		titleView = (TextView) rowView.findViewById(R.id.title);
		
		iconView.setImageResource(menuList.get(position).getResId());
		titleView.setText(menuList.get(position).getCountry());
		
		return rowView;
	}

}
