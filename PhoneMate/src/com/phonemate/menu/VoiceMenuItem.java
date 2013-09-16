package com.phonemate.menu;

import com.phonemate.menu.types.VoiceMenuMessage;

public class VoiceMenuItem {

   
	String welcomeMsg;
	String shortMsg;
	int    digit;
	private String action;
	
	
	public VoiceMenuItem(int digit, String shortMsg,String welcomeMsg) {
		super();
		this.welcomeMsg = welcomeMsg;
		this.shortMsg = shortMsg;
		this.digit = digit;
		this.action = "menu";
	}




	public String getShortMessage() {
		return shortMsg;
	}
	
	
	public void setShortMessage(String pMessage){
	
		this.shortMsg = pMessage;
	}
	
	
	public void setWelcomeMessage(String pVmw) {
		
		this.welcomeMsg = pVmw;
	}
	
	public String getWelcomeMessage() {
		return welcomeMsg;
	}
	
	
	public void setSubmenu(VoiceMenu v) {
	}
	
	
	public VoiceMenu getSubmenu() {
		return null;
	}
	
	public void setDigit(int pMenuDigit) {
	   this.digit = pMenuDigit;
	}
	
	
	public int getDigit() {
		return this.digit;
	}



	public String getAction() {
		return action;
	}
	
	
	public void setAction(String pAction) {
		
		this.action = pAction;
		
	}
	
	
}
