package com.example.phonemate;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.entity.ByteArrayEntity;


import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyPhoneMenusListItemAdapter;
import com.example.phonemate.adapters.PhoneMenuItem;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.phonemate.menu.VoiceMenu;
import com.phonemate.menu.VoiceMenuWelcomeMessage;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NewMyMenusActivity extends Activity {

     final int  WELCOME_MESSAGE = 0;
     final int  OPTIONS_MESSAGE = 1;
    
	MyPhoneMenusListItemAdapter adapter;
	VoiceMenu vm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.new_my_menu_number);
		adapter = new MyPhoneMenusListItemAdapter(this);
		adapter.init();
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu_actionbar, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	     /*   case R.id.action_add_menu_item:{
	            // app icon in action bar clicked; go home
	        	adapter.addItem(new PhoneMenuItem("new item", R.drawable.device_access_call,0));
	        	adapter.notifyDataSetChanged();
	            return true;
	        }*/
	    
	        default:
	        {
	        	System.out.println(" onOptionsItemSelected - " + item.getItemId());
	            return super.onOptionsItemSelected(item);
	        }
	    }

	}
	
	 protected void onActivityResult(int requestCode, 
			                         int resultCode,
			                         Intent data) {
		 
		 if(resultCode == Activity.RESULT_CANCELED){
			 
			 Log.d("Debug","Nothing to update ");
			 return;
		 }
		 
		 
		 switch(requestCode){
		 
		 case WELCOME_MESSAGE:{
			 
			   Log.d("DEBUG","Welcome message :" + data.getStringExtra("WELCOME_MSG"));
			   //adapter.setWelcomeMessage(new VoiceMenuWelcomeMessage(data.getStringExtra("WELCOME_MSG").toString()));
		 }
		 break;
		 case OPTIONS_MESSAGE:{
			 
			   String option = data.getStringExtra("OPTION");
			   Log.d("DEBUG","OPTION :" + option);
			   Log.d("DEBUG","Welcome message :" + data.getStringExtra("WELCOME_MSG"));
			   Log.d("DEBUG","Options message :" + data.getStringExtra("SHORT_MSG"));
			  // adapter.updateMenuItem(Integer.parseInt(option), data.getStringExtra("SHORT_MSG"));
		 }
		 break;
		 
		 
		 
		 }
		
		 /*Print our Json here*/
		 adapter.getJson();
		 try {
			syncMenuWithServer();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

	private void syncMenuWithServer() throws UnsupportedEncodingException {
	
		String jsonStr = adapter.getJson();
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(10000);
		//ByteArrayEntity entity = new ByteArrayEntity(jsonStr.getBytes("UTF-8"));
		 RequestParams params = new RequestParams();
		 params.put("menu", jsonStr);
		 params.put("phone_number","+61871001397");
		
		client.post(this, "http://192.168.1.5/twilio-labs/saveMenu.php",params ,  new AsyncHttpResponseHandler() {
        	@Override
            public void onSuccess(String response) {
            Log.d("Debug","got this one !"+ response);
        		}});
		
	}

}
