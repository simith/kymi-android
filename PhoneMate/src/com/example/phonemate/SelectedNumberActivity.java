package com.example.phonemate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.resources.ResourceManager;

public class SelectedNumberActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_number);
		Intent intent = getIntent();
		String countryCode = intent.getStringExtra("COUNTRY_CODE");
		String countryName = intent.getStringExtra("COUNTRY_NAME");
		String phoneNumber = intent.getStringExtra("PHONE_NUMBER");
	
		ImageView i = (ImageView)findViewById(R.id.selectedCountryImg);
		TextView countryNameView = (TextView)findViewById(R.id.selectedCountryName);
		TextView phoneNumberView = (TextView)findViewById(R.id.selectedPhoneNumber);
		i.setImageResource(ResourceManager.getCountryFlag(countryCode));
		countryNameView.setText(countryName);
		phoneNumberView.setText(phoneNumber);
		
		Button buyButton = (Button)findViewById(R.id.buyButton);
		
		buyButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Intent intentMyNumbers = new Intent(SelectedNumberActivity.this, BuyNumberInAppActivity.class);
				startActivity(intentMyNumbers);
			}
			
			
		}
		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_number, menu);
		return true;
	}

}
