package com.example.phonemate;

import java.lang.reflect.Type;
import java.util.List;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyPhoneNumbersListItemAdapter;
import com.example.phonemate.data.types.IncomingPhoneNumberItem;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.os.Bundle;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MyPhoneNumbersActivity extends ListActivity {

	
	MyPhoneNumbersListItemAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new MyPhoneNumbersListItemAdapter(this);
		adapter.init();
		setListAdapter(adapter);
		ListView lv = getListView();
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
					long arg3) {
				
				IncomingPhoneNumberItem item = (IncomingPhoneNumberItem) adapter.getItem(pos);
				Intent myMenuIntent = new Intent(MyPhoneNumbersActivity.this,NumberSettingsActivity.class);
				myMenuIntent.putExtra("PHONE_NUMBER", item.getPhoneNumber());
				startActivity(myMenuIntent);
	
			 }
	      });
		
		final ProgressDialog dialog = ProgressDialog.show(MyPhoneNumbersActivity.this, "", 
                "Loading. Please wait...", true);
		/*Go fetch the latest incoming numbers we have from Twilio*/
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(10000);
		
		/*client.get("http://others-eapps.rhcloud.com/twilio-labs/getIncomingNumbers.php",  new AsyncHttpResponseHandler(){*/
		client.get("http://others-eapps.rhcloud.com/app/2013-08-01/Accounts/simithn@gmail.com/IncomingNumbers",  new AsyncHttpResponseHandler(){	
			@Override
            public void onSuccess(String response){
				
			     Log.d("DEBUG",response);
			     Gson gson = new Gson();
	        	Type collectionType = new TypeToken<List<IncomingPhoneNumberItem>>() {
	        		}.getType();
	        List<IncomingPhoneNumberItem> incomingPhoneNumbers = gson.fromJson(response, collectionType);
	        
	        if(incomingPhoneNumbers != null){
	       	for(IncomingPhoneNumberItem inc:  incomingPhoneNumbers){
	        		
	        		Log.d("DEBUG","My number:" + inc.getPhoneNumber());
	        	}
			     
	       	 adapter.updateSearchResults(incomingPhoneNumbers);
	        }
	       	
				dialog.dismiss();
			}
			
			@Override
        	public void onFailure(Throwable e) {
        	    Log.e("ERROR", "OnFailure!", e);
        	    dialog.dismiss();
        	  
        	}
			
			@Override
        	public void onFailure(Throwable e, String response) {
        	    Log.e("ERROR", "OnFailure!", e);
        	    dialog.dismiss();
        	}
			
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_phone_numbers, menu);
		return true;
	}

}
