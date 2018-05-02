package edu.yccc.cis174.wlago.portraitgallery;

public class GameCastle extends GameRules {
	
	public String start()
	{
		GameState.roomX = 0;
		GameState.roomY = 0;
		return "You touch the painting and suddenly feel yourself pulled from your world into another, swirling turbulently through time and space...\n\n";
	}
	
	public String getRoomDesc()
	{
		if (GameState.roomX == 0 && GameState.roomY == 0)
		{
			if (GameState.candle.locX == 0 && GameState.candle.locY == 0)
			{
				return "You find yourself in what appears to be some sort of closet, with rough stone walls and wooden shelves containing all manner of miscellaneous tools and supplies. The exit is to the south.\nA lit candle sits on one of the shelves, casting flickering light throughout the small room.\n\n";
			}
			else
			{
				return "You find yourself in what appears to be some sort of closet, with rough stone walls and wooden shelves containing all manner of miscellaneous tools and supplies. The exit is to the south.\n\n";
			}
		}
		return null;
	}
	
	public String move(String i)
	{
		if (i.toLowerCase().equals("s") || i.toLowerCase().contains("south"))
		{
			if (GameState.roomY == 0)
			{
				GameState.roomY++;
				return "You move north.\n\n" + getRoomDesc();
			}
			else
			{
				return "You can't move in that direction!\n\n";
			}
		}
		else
		{
			return "You can't move in that direction!\n\n";
		}
	}
	
	public String inspect(String i)
	{
		if ((i.toLowerCase().contains("candle")) && ((GameState.roomX == GameState.candle.locX && GameState.roomY == GameState.candle.locY) || GameState.candle.locX == 100))
		{
			return GameState.candle.desc;
		}
		else
		{
			return "Look at what?\n\n";
		}
	}
	
	public String get(String i)
	{
		if ((i.toLowerCase().contains("candle")) && ((GameState.roomX == GameState.candle.locX && GameState.roomY == GameState.candle.locY)))
		{
			GameState.candle.locX = 100;
			GameState.candle.locY = 100;
			return "Got the candle.\n\n";
		}
		else
		{
			return "Get what?\n\n";
		}
	}

}
