package com.example.phonemate.adapters;

public class PhoneMenuItem {

	private String name;
	int     menuId;
	int     resId;
	
	
	public PhoneMenuItem() {
		super();
		
	}
	
	
	public PhoneMenuItem(String name, int resId,int menuId) {
		super();
		this.name = name;
		this.menuId = menuId;
		this.resId = resId;
	}
	
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}



	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
