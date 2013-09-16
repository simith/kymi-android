package com.example.phonemate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.enterpriseapps.kymi.R;

public class ActivationCodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activation_code); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activation_code, menu);
		return true;
	}

}
