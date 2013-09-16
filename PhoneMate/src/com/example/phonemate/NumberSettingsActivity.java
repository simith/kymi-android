package com.example.phonemate;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyPhoneMenusListItemAdapter;
import com.example.phonemate.adapters.MyPhoneNumbersListItemAdapter;
import com.example.phonemate.adapters.NumberSettingsMenuAdapter;
import com.example.phonemate.adapters.PhoneMenuItem;
import com.phonemate.menu.VoiceMenu;
import com.phonemate.menu.VoiceMenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NumberSettingsActivity extends ListActivity {

	NumberSettingsMenuAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		adapter = new NumberSettingsMenuAdapter(this);
		adapter.init();
		setListAdapter(adapter);
		ListView lv = getListView();
		final String phoneNumber = i.getStringExtra("PHONE_NUMBER");
	    Log.d(this.getClass().toString(),"The PHONE NUMBER is :" + phoneNumber);
	    this.setTitle(phoneNumber);
	    
	    lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
					long arg3) {
				
				
				
				PhoneMenuItem pmi = (PhoneMenuItem) adapterView.getAdapter().getItem(pos);
				int pmiId = pmi.getMenuId();
				
				switch(pmiId)
				{
				case NumberSettingsMenuAdapter.PM_ITEM_MY_SETTINGS:{
					
					Intent intentNumberSettings = new Intent(NumberSettingsActivity.this, SettingsActivity.class);
					intentNumberSettings.putExtra("PHONE_NUMBER",phoneNumber );
					startActivityForResult(intentNumberSettings,NumberSettingsMenuAdapter.PM_ITEM_MY_SETTINGS);
				
				}
				break;
                case NumberSettingsMenuAdapter.PM_ITEM_VOICE_MENU:{
					
					Intent intentVoiceMenu = new Intent(NumberSettingsActivity.this, MyMenusActivity.class);
					intentVoiceMenu.putExtra("PHONE_NUMBER",phoneNumber );
					startActivityForResult(intentVoiceMenu,NumberSettingsMenuAdapter.PM_ITEM_VOICE_MENU);
				
				}
				break;
				
				}
			}
        	
        });
	    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.number_settings, menu);
		return true;
	}
	
	protected void onActivityResult(int requestCode, 
            						int resultCode,
            						Intent data) 
	{

           if(resultCode == Activity.RESULT_CANCELED){

        	   Log.d("Debug","Nothing to update ");
        	   return; 
           }
           
	}

}
