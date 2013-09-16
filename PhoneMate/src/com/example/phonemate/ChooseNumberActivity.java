package com.example.phonemate;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

import com.enterpriseapps.kymi.R;

public class ChooseNumberActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_number);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_number, menu);
		return true;
	}

}
