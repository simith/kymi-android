package com.example.phonemate.bootstrap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.enterpriseapps.kymi.R;
import com.example.phonemate.LoginActivity;
import com.example.phonemate.MainActivity;
import com.example.phonemate.RegistrationActivity;

public class SignUpActivity extends Activity {

    @SuppressLint({ "NewApi" })
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        Button button = (Button) findViewById(R.id.loginButton);

        button.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  Intent loginActivity = new Intent(SignUpActivity.this, LoginActivity.class);
			  startActivityForResult(loginActivity, 0);
          }

		
        });
        
        button = (Button) findViewById(R.id.signupButton);

        button.setOnClickListener(new OnClickListener()
        {
          public void onClick(View v)
          {
        	  Intent loginActivity = new Intent(SignUpActivity.this, RegistrationActivity.class);
			  startActivityForResult(loginActivity, 0);
          }

		
        });

       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.activity_sign_up, menu);
        return true;
    }
    
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
    	
    	
    	if(resultCode == Activity.RESULT_OK){
    		
    		Intent mainActivity = new Intent(SignUpActivity.this, MainActivity.class);
			startActivity(mainActivity);
    	}
    	else{
    		
    		//
    	}
    }
}
