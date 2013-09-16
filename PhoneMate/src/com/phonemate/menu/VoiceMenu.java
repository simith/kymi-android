package com.phonemate.menu;

import java.util.LinkedList;
import java.util.List;

public class VoiceMenu {

	private String menuId;
	private String shortDesc;
	private VoiceMenuWelcomeMessage welcomeMessage;
	public  VoiceMenuWrapper menu;
	
	
	
	
	public VoiceMenu() {
		super();
		this.welcomeMessage = new VoiceMenuWelcomeMessage();
		this.menu = new VoiceMenuWrapper();
		this.menu.menuItems =new LinkedList<VoiceMenuItem>();
	}


	public VoiceMenu(VoiceMenuWelcomeMessage welcomeMessage, List<VoiceMenuItem> menuItems) {
		
		this.welcomeMessage = welcomeMessage;
		this.menu.menuItems = menuItems;
	}
	
	
	public VoiceMenuWelcomeMessage getWelcomeMessage() {
		return welcomeMessage;
	}
	public void setWelcomeMessage(VoiceMenuWelcomeMessage vmw) {
		this.welcomeMessage = vmw;
	}
	


	public String getMenuId() {
		return menuId;
	}


	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


	public String getShortDesc() {
		return shortDesc;
	}


	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	
}
