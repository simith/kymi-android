package com.example.phonemate.data.types;

public class PhoneNumberItem {

	String number;
	String country_code;
	
		
	public PhoneNumberItem() {
		super();
	}
	
	
	public PhoneNumberItem(String number, String country_code) {
		super();
		this.number = number;
		this.country_code = country_code;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getCountry_code() {
		return country_code;
	}
	
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	
	
}
