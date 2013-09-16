package com.example.phonemate.resources;


import com.enterpriseapps.kymi.R;
import com.example.phonemate.resources.countries.*;

public class ResourceManager {

	public static int getCountryFlag(String pCountryCode) {

		int resId = -1;

		CountryCode c = CountryCode.valueOf(pCountryCode);

		switch (c) {

		case AU: {

			resId = R.drawable.au;
		}
			break;
		case NZ: {

			resId = R.drawable.nz;
		}
			break;
		case AT: {

			resId = R.drawable.at;

		}
			break;

		case BE: {

			resId = R.drawable.be;

		}
			break;

		case BR: {

			resId = R.drawable.br;

		}
			break;
			
		case CA: {

			resId = R.drawable.ca;

		}
		break;
		

		case FI: {

			resId = R.drawable.fi;

		}
			break;
			
		case FR: {

			resId = R.drawable.fr;

		}
		break;	
		case GB: {

			resId = R.drawable.gb;

		}
		break;
		case HK: {

			resId = R.drawable.hk;

		}
		break;
		case IE: {

			resId = R.drawable.ie;

		}
		break;
		case IL: {

			resId = R.drawable.il;

		}
		break;
		
		case IT: {

			resId = R.drawable.it;

		}
		break;
		
		case JP: {

			resId = R.drawable.jp;

		}
		break;
		
		case US: {

			resId = R.drawable.us;

		}
		break;
		
		}

		return resId;
	}

}
