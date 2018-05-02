package edu.yccc.cis174.wlago.portraitgallery;

public class Item {
	
	String name = null;
	String desc = null;
	int subGame = 999;
	int locX = 999;
	int locY = 999;

	public Item(String n, String d, int x, int y, int sg)
	{
		this.name = n;
		this.desc = d;
		this.locX = x;
		this.locY = y;
		this.subGame = sg;
	}
}
