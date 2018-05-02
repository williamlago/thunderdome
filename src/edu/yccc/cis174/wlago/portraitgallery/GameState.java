package edu.yccc.cis174.wlago.portraitgallery;

import java.io.Serializable;

public class GameState implements Serializable {
		
	static int subGame = 0; //0 = hub, 1 = prehistoric, 2 = western, 3 = castle, 4 = space
	static int roomX = 0;
	static int roomY = 0;
	static boolean initialized = false;
	static boolean finishedPrehistoric = false;
	static boolean finishedWestern = false;
	static boolean finishedCastle = false;
	static boolean finishedSpace = false;
	
	static GameHub gh = null;
	static GamePrehistoric gp = null;
	static GameCastle gc = null;
	
	static Item stick1 = new Item("a stick", "A fairly standard piece of a tree branch.\n\n", -1, 0, 1);
	static Item stick2 = new Item("a stick", "A fairly standard piece of a tree branch.\n\n", 0, -1, 1);
	static Item candle = new Item("a candle", "There's not much of it left, but it'll do.\n\n", 0, 0, 3);
	
	public static void sync(GameState gs)
	{
		subGame = gs.subGame;
		roomX = gs.roomX;
		roomY = gs.roomY;
		initialized = gs.initialized;
		finishedPrehistoric = gs.finishedPrehistoric;
		finishedWestern = gs.finishedWestern;
		finishedCastle = gs.finishedCastle;
		finishedSpace = gs.finishedSpace;
		stick1.locX = gs.stick1.locX;
		stick1.locY = gs.stick1.locY;
		stick1.subGame = gs.stick1.subGame;
		stick2.locX = gs.stick2.locX;
		stick2.locY = gs.stick2.locY;
		stick2.subGame = gs.stick2.subGame;
	}

}
