package com.example.phonemate;


import java.io.IOException;
import java.net.URI;

import com.enterpriseapps.kymi.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;

public class RecordPlayerActivity extends Activity{

	MediaPlayer mPlayer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_record_player);
		Intent intent = getIntent();
		String vmUrl = intent.getStringExtra("VM_URL");
		Uri uriToStream = Uri.parse(vmUrl);
		Log.d("DEBUG","URL to stream: " + vmUrl);
		mPlayer = new  MediaPlayer();
		try {
			mPlayer.setDataSource(vmUrl);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		mPlayer.setOnPreparedListener(new OnPreparedListener() {
			
		    public void onPrepared(MediaPlayer mp) {
		        Log.d("DEBUG","Starting now....");
		        mp.start();
		    }
		});
		
		
        mPlayer.setOnCompletionListener(new OnCompletionListener() {

           @Override
           public void onCompletion(MediaPlayer mp) {
               Log.d("DEBUG","finished playing audio");
               mp.release();
               mp=null;
           }
        });   
       
    	mPlayer.prepareAsync();
		//mPlayer.start();
		
       
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		if(mPlayer != null){
			
			if(mPlayer.isPlaying() ==true){
				
			    Log.d("DEBUG","Player is playing");
				mPlayer.stop();
			}
			
		}
		
	}
		
}

	

	
	
	
	
	
	
	
	
	

