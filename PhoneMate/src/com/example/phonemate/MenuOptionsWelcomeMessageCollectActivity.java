package com.example.phonemate;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.bootstrap.SignUpActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MenuOptionsWelcomeMessageCollectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_options_collect_welcome_message);
		Intent i = getIntent();
		String msg = i.getStringExtra("WELCOME_MSG");
		EditText welcomMsgView = (EditText)findViewById(R.id.welcomeMsg);
		welcomMsgView.setText(msg);
		Button saveButton = (Button)findViewById(R.id.saveWmBtn);
		saveButton.setOnClickListener(new OnClickListener()
	        {
	          public void onClick(View v)
	          {
	        	  EditText welcomMsgView = (EditText)findViewById(R.id.welcomeMsg);
	        	  Intent resultIntent = new Intent();
	        	  Log.d("DEBUG","Welcome message collected is:"+welcomMsgView.getText());
	        	  resultIntent.putExtra("WELCOME_MSG", welcomMsgView.getText().toString());
					// TODO Add extras or a data URI to this intent as appropriate.
				  setResult(Activity.RESULT_OK, resultIntent);
				  finish();
	          }

			
	        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_options_collect, menu);
		return true;
	}

}
