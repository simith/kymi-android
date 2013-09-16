package com.example.phonemate;

import com.example.android.trivialdrivesample.util.IabHelper;
import com.example.android.trivialdrivesample.util.IabHelper.OnIabPurchaseFinishedListener;
import com.example.android.trivialdrivesample.util.IabResult;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BuyNumberInAppActivity extends Activity{
	
	
	private static final String TAG = "au.com.enterpriseapps.kymi.inappbilling";
	private static final String ITEM_SKU = "tel_au";
	IabHelper mHelper;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_in_app_billing);

		
		String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAraOJGWuKxGnN3zNNyooHGahV88SaDv5jPvhPrwWBqxjuvZ9UEip6K9Pg4WpyHfmjIV/M1OreL9AcSiD4aKwZeCUeqd/+tGnZ7gGAjcKnQ+skC7cjFyPDQLBK1vNi736cEASaB4sWpdFdCZ15UtUFK+WEjDy1ukVi+y3kyzduDXRHIIAd2HCEFmzaWxl4MDD/tJAVCiflFR9MdIX0MMoiFqkUjl6PmWw34zJlghjdsoiERaUu5tOovkkzYTEjKxYKPhJgmzhnGblW9iiD0yLkX5bVQZDR9QKfn5ej93jl/GzfbVTFb2OpP3swF6D0KwxExQj5CpYl3xNCUZFOZemS7QIDAQAB";
        
        	mHelper = new IabHelper(this, base64EncodedPublicKey);
        
        	mHelper.startSetup(new 
			IabHelper.OnIabSetupFinishedListener() {
        	   	  public void onIabSetupFinished(IabResult result) 
			  {
        	        if (!result.isSuccess()) {
        	           Log.d(TAG, "In-app Billing setup failed: " + 
					result);
        	      } else {             
        	      	    Log.d(TAG, "In-app Billing is set up OK");
        	      	    buyClick();
        	      	    
		      }
        	   }

				
        	});
	} 

	public void buyClick() {
	     
		 mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001,   
   			   null, "");
}
}
