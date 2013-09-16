package com.example.phonemate;


import org.json.JSONArray;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.AppMainMenuListItemAdapter;
import com.example.phonemate.adapters.PhoneMenuItem;
import com.example.phonemate.settings.Settings;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ListActivity {
     
	protected static final String TAG = "ERROR";
	AppMainMenuListItemAdapter adapter;
	@Override
	public void setListAdapter(ListAdapter adapter) {
		// TODO Auto-generated method stub
		super.setListAdapter(adapter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		
		
		//getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
		adapter = new AppMainMenuListItemAdapter(this);
		adapter.init();
		setListAdapter(adapter);
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
						long arg3) {
					
					PhoneMenuItem pmi = (PhoneMenuItem) adapterView.getAdapter().getItem(pos);
					int pmiId = pmi.getMenuId();
					
					switch(pmiId)
					{
					case AppMainMenuListItemAdapter.PM_ITEM_BUY_A_NUMBER:{
						
						Intent intentBuyNumber = new Intent(MainActivity.this, BuyNumberActivity.class);
						//Intent intentBuyNumber = new Intent(MainActivity.this, DSLVActivityTest.class);
						startActivity(intentBuyNumber);
					
					}
					break;
					case AppMainMenuListItemAdapter.PM_ITEM_MY_NUMBERS:{
						Intent intentMyNumbers = new Intent(MainActivity.this, MyPhoneNumbersActivity.class);
						startActivity(intentMyNumbers);
					}
					break;
					
					case AppMainMenuListItemAdapter.PM_ITEM_MY_MENU:{
						
						/*Intent intentMyMenu = new Intent(MainActivity.this, MyMenusActivity.class);
						intentMyMenu.putExtra("PHONE_NUMBER", "+61871001397");
						startActivity(intentMyMenu);*/
					}
					break;
                    case AppMainMenuListItemAdapter.PM_ITEM_VOICEMAIL:{
						
						Intent intentMyNumbers = new Intent(MainActivity.this, MyVoicemailActivity.class);
						startActivity(intentMyNumbers);
					}
					break;
                    case AppMainMenuListItemAdapter.PM_ITEM_MY_SETTINGS:{
						
						Intent settingsActivity = new Intent(MainActivity.this,WebViewActivity.class);
						startActivity(settingsActivity);
						
					}
					break;
					}
					
					
				}
	        	
	        });
		//setContentView(R.layout.activity_main);
		 
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	/*public void onBackPressed() {
	       // Do as you please
	}*/
}
