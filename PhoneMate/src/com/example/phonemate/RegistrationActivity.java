package com.example.phonemate;

import com.enterpriseapps.kymi.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.phonemate.menu.VoiceMenu;
import com.phonemate.menu.types.AccountCreationResult;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class RegistrationActivity extends Activity {

	ProgressDialog dialog = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}
	
	 public void goToActivationCodeCollection(View view) {
		 
		 
		 String pEmail = ((EditText)findViewById(R.id.email)).getText().toString();
		 String pPassword = ((EditText)findViewById(R.id.password)).getText().toString();
		 String pMobile = ((EditText)findViewById(R.id.phoneNumber)).getText().toString();
		 /*Intent i = new Intent(RegistrationActivity.this,ActivationCodeActivity.class);
		 startActivity(i);*/
		 EditText t = (EditText) findViewById(R.id.phoneNumber);
		 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
         imm.hideSoftInputFromWindow(t.getWindowToken(), 0);
         
         dialog = ProgressDialog.show(RegistrationActivity.this, "", 
                 "Creating Account, Please wait...", true);
		 registerAccount(pEmail,pPassword,pMobile);
	     
	 }
	 
	 private void registerAccount(String pEmail,
			 						   String pPassword,
			 						   String pMobile)
	 {
			
			
			
			 AsyncHttpClient client = new AsyncHttpClient();
			 client.setTimeout(10000);
			//ByteArrayEntity entity = new ByteArrayEntity(jsonStr.getBytes("UTF-8"));
			 RequestParams params = new RequestParams();
			 params.put("email",pEmail);
			 params.put("password", pPassword);
			 params.put("mobile",pMobile);
			
			 client.post(this, "http://others-eapps.rhcloud.com/twilio-labs/account/createNewAccount.php",params ,  new AsyncHttpResponseHandler() {
			// client.get(this, "http://192.168.1.6/twilio-labs/findMenu.php",params ,  new AsyncHttpResponseHandler() {
	        	@Override
	            public void onSuccess(String response) { 
	            
	        		Log.d("Debug","got this one !"+ response);
	        		Gson gson = new Gson();
	        		AccountCreationResult result= gson.fromJson(response,AccountCreationResult.class); 
	        		
	        		if(result.getCode().equals("200")){
	        		Log.d("DEBUG","Account creation result: " + result.getCode());
	        		Log.d("DEBUG","Account creation result: " + result.getStatusDesc());
	        		Intent i = new Intent(RegistrationActivity.this,ActivationCodeActivity.class);
	       	        startActivity(i); 
	        		}else if(result.getCode().equals("200")){
	        			
	        			
	        		}
	        		dialog.dismiss(); 
	        	
	        	}
	        	
	        	 public void onFailure(){
	        		 
	        		 dialog.dismiss();
	        	 }
	          }
			 );
		
			
		}

}
