package com.example.phonemate;



import java.lang.reflect.Type;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.resources.countries.*;
import com.example.phonemate.adapters.CountryListItemAdapter;
import com.example.phonemate.adapters.PhoneNumbersListItemAdapter;
import com.example.phonemate.data.types.CountryListItem;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class BuyNumberActivity extends Activity {

	PhoneNumbersListItemAdapter pm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_number);
		Spinner spinner = (Spinner)findViewById(R.id.country_list);
		CountryListItemAdapter cl= new CountryListItemAdapter(this);
		cl.init();
		spinner.setAdapter(cl);
		ListView l = (ListView) findViewById(R.id.list);
		pm = new PhoneNumbersListItemAdapter(this);
		pm.init();
		l.setAdapter(pm);
		
		l.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
					long arg3) {
				
				
				
				PhoneNumberItem p = (PhoneNumberItem) pm.getItem(pos);
				CountryListItem c = getSelectedCountry();
				
				Intent intentMyNumbers = new Intent(BuyNumberActivity.this, SelectedNumberActivity.class);
				intentMyNumbers.putExtra("COUNTRY_CODE", p.getCountry_code());
				intentMyNumbers.putExtra("COUNTRY_NAME", c.getCountry());
				intentMyNumbers.putExtra("PHONE_NUMBER", p.getNumber());
				
				startActivity(intentMyNumbers);
				
				
			}
        	
        });
		
		//new JsonTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy_number, menu);
		return true;
	}

	
	
	
	public void searchNumbers(View v){
		
		CountryListItem item = getSelectedCountry();
		pm.clearResults();
	
		final ProgressDialog dialog = ProgressDialog.show(BuyNumberActivity.this, "", 
                "Loading. Please wait...", true);
		
		
		if(item != null){
			
			Log.d("DEBUG","Selected Country is: "+ item.getCountry());
	
	    	EditText t = (EditText) findViewById(R.id.searchText);
	    	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(t.getWindowToken(), 0);
            CountryCode c = item.getCountryCode();
		    //pm.search(item.getCountryCode(),t.getText().toString());
	    	AsyncHttpClient client = new AsyncHttpClient();
			client.setTimeout(10000);

		        client.get("http://others-eapps.rhcloud.com/twilio-labs/getAccounts.php?country_code="+
		        c.toString()+"&search_pattern="+ t.getText().toString(), new AsyncHttpResponseHandler() {
		        	@Override
		            public void onSuccess(String response) {
		            	Log.d(null,response);
		                Log.d(null,"Done HTTP request Response received!");
		                Gson gson = new Gson();
		        		Type collectionType = new TypeToken<List<PhoneNumberItem>>() {
		        		}.getType();
		        		List<PhoneNumberItem> details = gson.fromJson(response, collectionType);

		        		if(details != null){
		        		
		        		for (PhoneNumberItem item : details) {

		        			System.out.println("Country code: " + item.getCountry_code());
		        			System.out.println("Number: " + item.getNumber());

		        		}
		        		
		        		int count = pm.updateSearchResults(details);
		        		updateSearchResultsCount(count);
		        		}
		        		else{
		        			
		        		pm.clear();	
		        		updateSearchResultsCount(0);
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
		        
		        	
		        	
		        }); //get ends here
		
	      }//if ends here
	
}	
	
	
	private void updateSearchResultsCount(int pCount) {
		
	  TextView searchResultsTitle = (TextView)findViewById(R.id.searchResultsTitle);
	  searchResultsTitle.setText("Search results ("+pCount+")");	
	}	
	
	
	private CountryListItem getSelectedCountry(){
	
		Spinner spinner = (Spinner)findViewById(R.id.country_list);
		Log.d("DEBUG","Selected Spinner position is: "+ spinner.getSelectedItemPosition());
		CountryListItem item = (CountryListItem)spinner.getSelectedItem();
		
	    return item;
	}
	
	
}
