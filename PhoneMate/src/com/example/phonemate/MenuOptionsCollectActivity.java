package com.example.phonemate;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.*;
import com.example.phonemate.adapters.PhoneMenuItem;
import com.example.phonemate.adapters.PostPhoneMenuListItemAdapter;

public class MenuOptionsCollectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_options_collect);
		Intent i = getIntent();
		String msg = i.getStringExtra("WELCOME_MSG");
		String optionNumber = i.getStringExtra("OPTION"); 
		String shortMsg =  i.getStringExtra("SHORT_MSG"); 
		String action = i.getStringExtra("ACTION");
		EditText shortMsgView = (EditText)findViewById(R.id.optionsShortMsg);
		EditText welcomMsgView = (EditText)findViewById(R.id.optionsWelcomeMsg);
		TextView optionNumView = (TextView)findViewById(R.id.digitCollectedTxt);
		optionNumView.setText(optionNumber);
		shortMsgView.setText(shortMsg);
 		welcomMsgView.setText(msg);
 		
 		Spinner postMenuOptions = (Spinner)findViewById(R.id.optionsList);
 		PostPhoneMenuListItemAdapter pi = new PostPhoneMenuListItemAdapter(this);
 		pi.init();
 		
 		postMenuOptions.setAdapter(pi);
 		int selectedSpinnerPosition = pi.getSpinnerPosition(action);
 		postMenuOptions.setSelection(selectedSpinnerPosition);
 		
		
		Button saveButton = (Button)findViewById(R.id.saveOptionsCollectBtn);
		saveButton.setOnClickListener(new OnClickListener()
	        {
	          public void onClick(View v)
	          {
	        	  EditText welcomMsgView = (EditText)findViewById(R.id.optionsWelcomeMsg);
	        	  EditText optionsMsgView = (EditText)findViewById(R.id.optionsShortMsg);
	        	  String action = null;
	        	  Spinner postMenuOption = (Spinner)findViewById(R.id.optionsList);
	           	  PhoneMenuItem pm = (PhoneMenuItem) postMenuOption.getSelectedItem();
	           	  String pmAction = null;
	           	  
	           	  if(pm != null){
	           		  
	           		  int menuId = pm.getMenuId();
	           		  
	           		  pmAction = getActionOnMenuId(menuId);
	           		  
	           	  }
	        	  
	        	  String welcomeMsg = null,optionShortMsg = null;
	        	  
	        	  if(welcomMsgView.getText() != null){
	        		  
	        		  welcomeMsg = welcomMsgView.getText().toString();
	        	  }
	        	  
                  if(optionsMsgView.getText() != null){
	        		  
                	  optionShortMsg = optionsMsgView.getText().toString();
	        	  }
	        	  Intent resultIntent = new Intent();
	        	  Log.d("DEBUG","Welcome message collected is:"+welcomeMsg);
	        	  resultIntent.putExtra("WELCOME_MSG", welcomeMsg);
	        	  resultIntent.putExtra("SHORT_MSG", optionShortMsg);
	        	  resultIntent.putExtra("OPTION", getIntent().getStringExtra("OPTION"));
	        	  resultIntent.putExtra("ACTION", pmAction);
					// TODO Add extras or a data URI to this intent as appropriate.
				  setResult(Activity.RESULT_OK, resultIntent);
				  finish();
	          }

			
			
	        });
		
		
	}

	
	private String getActionOnMenuId(int menuId) {
		String action = null;
		
		switch(menuId){
		
		case PostPhoneMenuListItemAdapter.PM_POST_MENU_MAIN_MENU:{
			
			action = "menu";
		}
		break;
		
		case PostPhoneMenuListItemAdapter.PM_POST_MENU_DIAL_OUT:{
			
			action = "dial-out";
		}
		break;
		
		case PostPhoneMenuListItemAdapter.PM_POST_MENU_RECORD_MSG:{
			action = "record";
		}
		break;
		
		}
		
		return action;
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_options_collect, menu);
		return true;
	}
	
	
	

}
