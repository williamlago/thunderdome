package edu.yccc.cis174.wlago.portraitgallery;

public interface GameInterface {
	
	String parse(String i);
	String move(String i);
	String inspect(String i);
	String talk(String i);
	String get(String i);
	String inventory();
	String getRoomDesc();
	String help();
	void save();
	void load();
	void quit();
	
}
