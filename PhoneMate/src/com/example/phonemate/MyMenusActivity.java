package com.example.phonemate;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.entity.ByteArrayEntity;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.adapters.MyPhoneMenusListItemAdapter;
import com.example.phonemate.adapters.PhoneMenuItem;
import com.example.phonemate.data.types.PhoneNumberItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.phonemate.menu.VoiceMenu;
import com.phonemate.menu.VoiceMenuItem;
import com.phonemate.menu.VoiceMenuWelcomeMessage;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;




public class MyMenusActivity extends ListActivity {

     final int  WELCOME_MESSAGE = 0;
     final int  OPTIONS_MESSAGE = 1;
     ProgressDialog dialog = null;
     
    String phoneNumber;
	MyPhoneMenusListItemAdapter adapter;
	VoiceMenu vm;
	
	  private DragSortListView.DropListener onDrop =
		        new DragSortListView.DropListener() {
		            @Override
		            public void drop(int from, int to) {
		                if (from != to) {
		                    DragSortListView list = (DragSortListView) getListView();
		                    VoiceMenuItem temp = vm.menu.getMenuItems().get(from);
		                    vm.menu.getMenuItems().remove(from);
		                    vm.menu.getMenuItems().add(to, temp);
		                    adapter.updateIndexes();
		                    //adapter.makeInternalFixes(from,to);
		                    adapter.notifyDataSetChanged();
		                    
		                    //list.moveCheckState(from, to);
		                    //Log.d("DSLV", "Selected item is " + list.getCheckedItemPosition());
		                }
		            }
		        };
		        
		        private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener()
		        {
		            @Override
		            public void remove(int which)
		            {
		                adapter.remove(adapter.getItem(which));
		            }
		        };    
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkable_main);
		Intent myMenuIntent = getIntent();
		phoneNumber = myMenuIntent.getStringExtra("PHONE_NUMBER");		
		adapter = new MyPhoneMenusListItemAdapter(this);
		adapter.init();
		setListAdapter(adapter);
		DragSortListView lv = (DragSortListView) getListView();
		vm = new VoiceMenu();
		
		
	    lv.setDropListener(onDrop);
	    lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	     //list.setBackgroundResource(R.drawable.customshape);
	    DragSortController controller = new DragSortController(lv);
	    controller.setDragHandleId(R.id.icon);
	    controller.setRemoveEnabled(false);
	    controller.setSortEnabled(true);
	    controller.setDragInitMode(1);
	    controller.setFlingHandleId(R.id.icon);
	                //controller.setRemoveMode(removeMode);

	   LinearLayout welcomeMsgLayout = (LinearLayout)findViewById(R.id.wMsgViewItem);
	    
	   welcomeMsgLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            	Intent intentCollectWelcomeMsg = new Intent(MyMenusActivity.this, MenuOptionsWelcomeMessageCollectActivity.class);
				intentCollectWelcomeMsg.putExtra("WELCOME_MSG", getAdapter().getVm().getWelcomeMessage().getMsg());
				startActivityForResult(intentCollectWelcomeMsg,WELCOME_MESSAGE);
            }
        });
	    
	    lv.setFloatViewManager(controller);
	    lv.setOnTouchListener(controller);
	    lv.setDragEnabled(true);
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1, int pos,
					long arg3) {
				
				VoiceMenu tempVm = getAdapter().getVm();
				
				PhoneMenuItem pmi = (PhoneMenuItem) adapterView.getAdapter().getItem(pos);
				int pmiId = pmi.getMenuId();
				
				switch(pmiId)
				{
				
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_1:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_2:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_3:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_4:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_5:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_6:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_7:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_8:
                case MyPhoneMenusListItemAdapter.PM_MENU_ITEM_OPTION_9:
                {
					
					Intent intentCollectOptionMsg = new Intent(MyMenusActivity.this, MenuOptionsCollectActivity.class);
					VoiceMenuItem tempVmItem = adapter.getMenuItem(pmiId);
					intentCollectOptionMsg.putExtra("OPTION", ""+ (pmiId + 1));
					intentCollectOptionMsg.putExtra("WELCOME_MSG",tempVmItem.getWelcomeMessage());
					intentCollectOptionMsg.putExtra("SHORT_MSG",tempVmItem.getShortMessage() );
					intentCollectOptionMsg.putExtra("ACTION", tempVmItem.getAction());
					
					startActivityForResult(intentCollectOptionMsg,OPTIONS_MESSAGE);
				
				}
				break;
			
				default:{
					
					
				}
				break;
				}
				
				
			}
        	
        });
		dialog = ProgressDialog.show(MyMenusActivity.this, "", 
                "Loading Voice Menu...", true);
		getMenuFromServer(this.phoneNumber);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu_actionbar, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	 /*   switch (item.getItemId()) {
	       case 1:{
	           
	    	    //sync the menu with the server.
	    	   
	            return true;
	        }
	    
	        default:
	        {
	        	System.out.println(" onOptionsItemSelected - " + item.getItemId());
	            return super.onOptionsItemSelected(item);
	        }
	    }*/
  return true;
	}
	
	 protected void onActivityResult(int requestCode, 
			                         int resultCode,
			                         Intent data) {
		 
		 if(resultCode == Activity.RESULT_CANCELED){
			 
			 Log.d("Debug","Nothing to update ");
			 return; 
		 }
		 
		 
		 switch(requestCode){
		 
		 case WELCOME_MESSAGE:{
			 
			   Log.d("DEBUG","Welcome message :" + data.getStringExtra("WELCOME_MSG"));
			   adapter.setWelcomeMessage(new VoiceMenuWelcomeMessage(data.getStringExtra("WELCOME_MSG").toString()));
		 }
		 break;
		 case OPTIONS_MESSAGE:{
			 
			   String option = data.getStringExtra("OPTION");
			   String shortMsg = data.getStringExtra("SHORT_MSG");
			   String welcomeMsg = data.getStringExtra("WELCOME_MSG");
			   String action = data.getStringExtra("ACTION");
			   Log.d("DEBUG","OPTION :" + option);
			   Log.d("DEBUG","Welcome message :" + welcomeMsg);
			   Log.d("DEBUG","Options message :" + shortMsg);
			 
			adapter.updateMenuItem(Integer.parseInt(option), shortMsg,welcomeMsg,action);
		 }
		 break;
		 
		 
		 
		 }
		
		 /*Print our Json here*/
		 adapter.getJson();
		 try {
			syncMenuWithServer();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

	private void syncMenuWithServer() throws UnsupportedEncodingException {
	
		String jsonStr = adapter.getJson();
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(10000);
		//ByteArrayEntity entity = new ByteArrayEntity(jsonStr.getBytes("UTF-8"));
		 RequestParams params = new RequestParams();
		 params.put("menu", jsonStr);
		 params.put("phone_number",this.phoneNumber);
		
		 client.post(this, "http://others-eapps.rhcloud.com/twilio-labs/saveMenu.php",params ,  new AsyncHttpResponseHandler() {
		// client.post(this, "http://192.168.1.6/twilio-labs/saveMenu.php",params ,  new AsyncHttpResponseHandler() {
        	@Override
            public void onSuccess(String response) {
            
        		Log.d("Debug","got this one !"+ response);
        	
        	}
          }
		 );
		
	}
	
	private VoiceMenu getMenuFromServer(String phoempVmneNumber){
		
		
		
		AsyncHttpClient client = new AsyncHttpClient();
		client.setTimeout(10000);
		//ByteArrayEntity entity = new ByteArrayEntity(jsonStr.getBytes("UTF-8"));
		 RequestParams params = new RequestParams();
		 params.put("phone_number",this.phoneNumber);
		
		 //client.get(this, "http://others-eapps.rhcloud.com/twilio-labs/findMenu.php",params ,  new AsyncHttpResponseHandler() {
		  client.get(this, "http://others-eapps.rhcloud.com/app/2013-08-01/Accounts/simithn@gmail.com/IncomingNumbers/+61385184843/Menu",params ,  new AsyncHttpResponseHandler() {
        	@Override
            public void onSuccess(String response) { 
            
        		Log.d("Debug","got this one !"+ response);
        		 Gson gson = new Gson();
        		 vm = gson.fromJson(response,VoiceMenu.class); 
        		 getAdapter().setVm(vm);
        		 getAdapter().notifyDataSetChanged();
        		 dialog.dismiss();
        	
        	}
        	
        	 public void onFailure(){
        		 
        		 dialog.dismiss();
        	 }
          }
		 );
	
		return vm;
	}

	public MyPhoneMenusListItemAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(MyPhoneMenusListItemAdapter adapter) {
		this.adapter = adapter;
	}
	
	

}
