package com.example.phonemate;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyPhoneMenusListItemAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;


public class DSLVActivityTest extends Activity {

	ListView listView;
	MyPhoneMenusListItemAdapter adapter;
	
  

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.adapter = new MyPhoneMenusListItemAdapter(this);
		adapter.init();
		setContentView(R.layout.activity_dslvactivity_test);
		//listView = new DragSortListView(this, null);
		listView = (ListView) findViewById(R.id.listview1);
		listView.setAdapter(adapter);
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.dslvactivity_test, menu);
		return true;
	}

}
