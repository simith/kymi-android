package com.phonemate.menu;

import java.util.LinkedList;
import java.util.List;


/*A class to comply to the JSON that is returned , for Gson to parse*/
public class VoiceMenuWrapper {

	public List<VoiceMenuItem> menuItems;
	
	public VoiceMenuWrapper() {
		super();
		this.menuItems = new LinkedList<VoiceMenuItem>();
	}
	
	
	public List<VoiceMenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<VoiceMenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public void
	addMenuItem(VoiceMenuItem pItem){
		
		this.menuItems.add(pItem);
	}
	
	
	
	
}
