package com.phonemate.menu;

import com.google.gson.Gson;

public class VoiceManuMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VoiceMenu vm = new VoiceMenu();
		vm.setWelcomeMessage(new VoiceMenuWelcomeMessage("Welcome to ANZ"));
		
		VoiceMenuItem vmi = new VoiceMenuItem(1, "Sales", "For speaking to a Customer Service exec please press # now");
		
        Gson g = new Gson();
        System.out.println("menu = " + g.toJson(vm));
	}

}
