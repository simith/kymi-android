package com.example.phonemate.data.types;

public class IncomingPhoneNumberItem {

	String phoneNumber;
	String phoneRefNumber;
	String mode;
	
	
	public IncomingPhoneNumberItem(String pPhoneNumber, String pPhoneNumberRef,
			String pMode) {
		super();
		this.phoneNumber = pPhoneNumber;
		this.phoneRefNumber = pPhoneNumberRef;
		this.mode = pMode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPhoneRefNumber() {
		return phoneRefNumber;
	}


	public void setPhoneRefNumber(String phoneNumberRef) {
		this.phoneRefNumber = phoneNumberRef;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}

}
