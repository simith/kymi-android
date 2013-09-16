package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.data.types.VoiceRecordingItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyVoicemailListItemAdapter extends BaseAdapter {

	 private List<VoiceRecordingItem> menuList;
	 private final Context context;
	 
		
	public MyVoicemailListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<VoiceRecordingItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
	
	
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
		
		iconView.setImageResource(R.drawable.av_play);
		titleView.setText(menuList.get(arg0).getDateCreated());
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(VoiceRecordingItem  p){
	
		menuList.add(p);
	}
	
	
   public void updateSearchResults(List<VoiceRecordingItem> voiceRecordings){
	   
	   int numberOfItems = 0;
		
		menuList.clear();
		menuList.addAll(voiceRecordings);
		notifyDataSetChanged();
	   
   }
}
