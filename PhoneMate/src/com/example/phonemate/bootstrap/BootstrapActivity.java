package com.example.phonemate.bootstrap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class BootstrapActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if(getPreferences(this.MODE_PRIVATE).getBoolean("signup",false) == true){
        	
            Log.d("Debug","Signup/Login page to be displayed");
        }
        else
        {
        	  Log.d("Debug","Login page to be displayed");
        	// Show login page as already signed up
        }
        
        setContentView(com.enterpriseapps.kymi.R.layout.activity_bootstrap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.activity_bootstrap, menu);
        return true;
    }
}
