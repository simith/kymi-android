package com.example.phonemate.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;

public class KymiApp extends Application{

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		 if(getSharedPreferences("kymi-trial", this.MODE_PRIVATE).getBoolean("signup",false) == false){
	        	
			    SharedPreferences  prefs = getSharedPreferences("kymi", this.MODE_PRIVATE);
			    prefs.edit().putBoolean("signup", true);
			    prefs.edit().commit();
	            Log.d("Debug","Signup/Login page to be displayed");
	        }
	        else
	        {
	        	  Log.d("Debug","Login page to be displayed");
	        	// Show login page as already signed up
	        }
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

}
