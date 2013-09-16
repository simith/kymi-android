package com.example.phonemate.adapters;

import java.util.LinkedList;
import java.util.List;

import com.enterpriseapps.kymi.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phonemate.menu.VoiceMenu;
import com.phonemate.menu.VoiceMenuItem;
import com.phonemate.menu.VoiceMenuWelcomeMessage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPhoneMenusListItemAdapter extends BaseAdapter {

	 private List<PhoneMenuItem> menuList;
	 private final Context context;
	 private VoiceMenu vm;
	
	 static PhoneMenuItem holder = new PhoneMenuItem();
	
	 
	 
	
	 public static final int PM_MENU_ITEM_OPTION_1 = 0;
	 public static final int PM_MENU_ITEM_OPTION_2 = 1;
	 public static final int PM_MENU_ITEM_OPTION_3 = 2;
	 public static final int PM_MENU_ITEM_OPTION_4 = 3;
	 public static final int PM_MENU_ITEM_OPTION_5 = 4;
	 public static final int PM_MENU_ITEM_OPTION_6 = 5;
	 public static final int PM_MENU_ITEM_OPTION_7 = 6;
	 public static final int PM_MENU_ITEM_OPTION_8 = 7;
	 public static final int PM_MENU_ITEM_OPTION_9 = 8;
	 
	public MyPhoneMenusListItemAdapter(Context ctxt) {
		super();
		menuList = new LinkedList<PhoneMenuItem>();
		// TODO Auto-generated constructor stub
		this.context = ctxt;
		
	}
	
	public void init(){
	 
	
		menuList.add(new PhoneMenuItem("1. Short name", R.drawable.menu,PM_MENU_ITEM_OPTION_1));
		menuList.add(new PhoneMenuItem("2. Short name", R.drawable.menu,PM_MENU_ITEM_OPTION_2));
		menuList.add(new PhoneMenuItem("3. Short name", R.drawable.menu,PM_MENU_ITEM_OPTION_3));
		menuList.add(new PhoneMenuItem("4. Short name", R.drawable.menu,PM_MENU_ITEM_OPTION_4));
		menuList.add(new PhoneMenuItem("5. Short name", R.drawable.menu,PM_MENU_ITEM_OPTION_5));
		
		vm = new VoiceMenu();
		/*vm.addMenuItem(new VoiceMenuItem(PM_MENU_ITEM_OPTION_1,"Short name",""));
		vm.addMenuItem(new VoiceMenuItem(PM_MENU_ITEM_OPTION_2,"Short name",""));
		vm.addMenuItem(new VoiceMenuItem(PM_MENU_ITEM_OPTION_3,"Short name",""));
		vm.addMenuItem(new VoiceMenuItem(PM_MENU_ITEM_OPTION_4,"Short name",""));
		vm.addMenuItem(new VoiceMenuItem(PM_MENU_ITEM_OPTION_5,"Short name",""));*/
		
		
		
	
	}

	@Override
	public int getCount() {
		// +1 for Welcome Message
		return vm.menu.getMenuItems().size() ;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		PhoneMenuItem pm;
		
		VoiceMenuItem temp = vm.menu.getMenuItems().get(pos);
	    holder.menuId = pos;
		holder.resId = R.drawable.menu;
		holder.setName(temp.getShortMessage());
		pm = holder;
	
		return pm;
		//return menuList.get(pos);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup parent) {
		ImageView iconView = null;
		TextView titleView = null;
		View rowView = null;
		
		//handle welcome message case, after sort has been introduced
		// we need to differentiate between what can be sorted and what not
		// The R.id.icon of rowview is draggable, but that is not present for the
		//welcome message row, hence wold not be dragaable, quick fix for now
		
		
		if(view == null){
		
		 LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		 
		 iconView = (ImageView) rowView.findViewById(R.id.icon);
		 titleView = (TextView) rowView.findViewById(R.id.title);
			
		 iconView.setImageResource(R.drawable.menu);
		
		}
		else
		{
		  rowView = view;	
		}
		
		iconView = (ImageView) rowView.findViewById(R.id.icon);
		titleView = (TextView) rowView.findViewById(R.id.title);
		
		iconView.setImageResource(R.drawable.menu);
		
	
			VoiceMenuItem vi = vm.menu.getMenuItems().get(arg0);
			titleView.setText(vi.getDigit() + ".  " + vi.getShortMessage());
			
		
		return rowView;
	}
	
	public void clear(){
	
		menuList.clear();
		
	}
	
	public void addItem(PhoneMenuItem p){
	
		menuList.add(p);
	}
	
	// the index passed starts at 1 , hence index - 1 to sync with 0 index menuItem list
	public void updateMenuItem(int pIndex,String pOptionTxt, String pWelcomeMsg, String pAction){
		//-1 as we are having a list and the index passed is welcome message + [0,1,2,3] menu items
		VoiceMenuItem  item = vm.menu.getMenuItems().get(pIndex);
		item.setShortMessage(pOptionTxt);
		item.setWelcomeMessage(pWelcomeMsg);
		item.setAction(pAction);
		notifyDataSetChanged();
		
	}
	
	//returns the menu item at index i.e. starting at 0
	public VoiceMenuItem getMenuItem(int pIndex){
		
		return  vm.menu.getMenuItems().get(pIndex);
		
	}

	public String  getJson() {
		String jsonStr = null;
		Gson gson = new GsonBuilder().serializeNulls().create();
		jsonStr= gson.toJson(vm);
		Log.d("Json is: ",jsonStr);
		return jsonStr;
		
	}

	

	public VoiceMenu getVm() {
		return vm;
	}

	public void setVm(VoiceMenu vm) {
		this.vm = vm;
	}
	
	public void setWelcomeMessage(
			VoiceMenuWelcomeMessage voiceMenuWelcomeMessage) {
			vm.setWelcomeMessage(voiceMenuWelcomeMessage);
			
		}

	public void remove(PhoneMenuItem item) {
		
		//vm.menu.menuItems.remove(item);
		
	}

	public void insert(PhoneMenuItem item, int to) {
		
		printList();
		
		//vm.menu.menuItems.add(to, item);
		
	}

	private void printList() {
		
		for(PhoneMenuItem m : menuList){
			Log.d("DEBUG","The item Id: "+ m.getMenuId());
			Log.d("DEBUG","The item name: "+ m.getName());
			
		}
	
		
	}

	public void remove(Object item) {
		
		menuList.remove(item);
		
		
	}
	
	

	/*public void makeInternalFixes(int from, int to) {
		
		VoiceMenuItem vmi = vm.menu.getMenuItems().get(from -1);
		vm.menu.getMenuItems().remove(from - 1);
		vm.menu.getMenuItems().add(to -1, vmi);
		updateIndexes();
		
	}
	*/
	public void updateIndexes(){
		
		int digit = 1;
		List<VoiceMenuItem> list = vm.menu.getMenuItems();
		
		Log.d("DEBUG","Before re-order:");
		 for(VoiceMenuItem i : list){
				
				Log.d("DEBUG"," Short Message: "+ i.getShortMessage() + " Digit: " + i.getDigit());
				
			}
		
		for(VoiceMenuItem i : list){
			
			i.setDigit(digit);
			digit++;
		}
		Log.d("DEBUG","After re-order:");
        for(VoiceMenuItem i : list){
			
			Log.d("DEBUG"," Short Message: "+ i.getShortMessage() + " Digit: " + i.getDigit());
			
		}
		
	}

}
