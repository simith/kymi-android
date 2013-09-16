package com.example.phonemate.data.types;

import com.example.phonemate.resources.countries.CountryCode;

public class CountryListItem {

	String country;
	CountryCode countryCode;
	int resId; // for the flag
	
	

	public CountryListItem(String country, CountryCode countryCode, int resId) {
		super();
		this.country = country;
		this.countryCode = countryCode;
		this.resId = resId;
	}

	public String getCountry() {
		return countryCode.getName();
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

}
