package com.example.phonemate;

import java.lang.reflect.Type;
import java.util.List;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyVoicemailListItemAdapter;
import com.example.phonemate.data.types.IncomingPhoneNumberItem;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.example.phonemate.data.types.VoiceRecordingItem;
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


public class MyVoicemailActivity extends ListActivity {

    private MyVoicemailListItemAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new MyVoicemailListItemAdapter(this);
		adapter.init();
		setListAdapter(adapter);
		
		
		ListView l = getListView();
		
		l.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
					long arg3) {
				
				VoiceRecordingItem v = (VoiceRecordingItem) adapter.getItem(pos);
				
				Intent playVmIntent = new Intent(MyVoicemailActivity.this, RecordPlayerActivity.class);
				String httpUrl = "http://api.twilio.com"+ v.getUri() + ".wav";
				playVmIntent.putExtra("VM_URL", httpUrl);
				startActivity(playVmIntent);
				
			}
			});
		
		final ProgressDialog dialog = ProgressDialog.show(MyVoicemailActivity.this, "", 
                "Loading. Please wait...", true);
		/*Go fetch the latest Recording we have from Twilio*/
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(10000);
		
		client.get("http://others-eapps.rhcloud.com/twilio-labs/getRecordings.php",  new AsyncHttpResponseHandler(){
			
			@Override
            public void onSuccess(String response){
				
			     Log.d("DEBUG",response);
			     Gson gson = new Gson();
	        	Type collectionType = new TypeToken<List<VoiceRecordingItem>>() {
	        		}.getType();
	             List<VoiceRecordingItem> voiceRecordings = gson.fromJson(response, collectionType);
	        
	        if(voiceRecordings != null){
	       	for(VoiceRecordingItem inc:  voiceRecordings){
	        		
	        		Log.d("DEBUG","My Recording URL :" + inc.getUri());
	        	}
			     
	       	 adapter.updateSearchResults(voiceRecordings);
	        }
	       	
				dialog.dismiss();
			}
	        }); //get ends here
		
 }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_phone_numbers, menu);
		return true;
	}

}
