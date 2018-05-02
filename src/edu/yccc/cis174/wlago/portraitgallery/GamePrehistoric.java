package edu.yccc.cis174.wlago.portraitgallery;

public class GamePrehistoric extends GameRules {
		
	public String start()
	{
		GameState.roomX = 0;
		GameState.roomY = 0;
		return "You touch the painting and suddenly feel yourself pulled from your world into another, swirling turbulently through time and space...\n\n";
	}
	
	public String move(String i)
	{
		if (i.toLowerCase().equals("n") || i.toLowerCase().contains("north"))
		{
			if ((GameState.roomX == 0 && GameState.roomY == 0) || (GameState.roomX == 0 && GameState.roomY == -1))
			{
				GameState.roomY++;
				return "You move north.\n\n" + getRoomDesc();
			}
			else
			{
				return "You can't move in that direction!\n\n";
			}
		}
		else if (i.toLowerCase().equals("s") || i.toLowerCase().contains("south"))
		{
			if ((GameState.roomX == 0 && GameState.roomY == 0) || (GameState.roomX == 0 && GameState.roomY == 1))
			{
				GameState.roomY--;
				return "You move south.\n\n" + getRoomDesc();
			}
			else
			{
				return "You can't move in that direction!\n\n";
			}
		}
		if (i.toLowerCase().equals("e") || i.toLowerCase().contains("east"))
		{
			if ((GameState.roomX == -1 && GameState.roomY == 0))
			{
				GameState.roomX++;
				return "You move east.\n\n" + getRoomDesc();
			}
			else
			{
				return "You can't move in that direction!\n\n";
			}
		}
		if (i.toLowerCase().equals("w") || i.toLowerCase().contains("west"))
		{
			if ((GameState.roomX == 0 && GameState.roomY == 0))
			{
				GameState.roomX--;
				return "You move west.\n\n" + getRoomDesc();
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
	
	public String talk(String i)
	{
		if (GameState.roomX == 0 && GameState.roomY == 1 && GameState.stick1.locX != 100 || GameState.stick2.locX != 100)
		{
			return "The caveman doesn't seem to speak English, but nonetheless he glances up at you and grunts shortly before looking back at the fire pit and scraping two rocks together with a frustrated expression. Is he trying to start a fire?\n\n";
		}
		else if (GameState.roomX == 0 && GameState.roomY == 1 && GameState.stick1.locX == 100 && GameState.stick2.locX == 100)
		{
			GameState.finishedPrehistoric = true;
			GameState.subGame = 0;
			GameState.roomX = 0;
			GameState.roomY = 0;
			GameState.stick1.locX = 999;
			GameState.stick1.locY = 999;
			GameState.stick2.locX = 999;
			GameState.stick2.locY = 999;
			return "You offer the two sticks to the caveman and he grabs them eagerly, furiously rubbing them against each other. His expression lights up as sparks form between them, igniting his primitive fire pit and filling the cave with warm light. He raises his fists in triumph and grins at you as you once again feel yourself being pulled into another world...\n\nDisoriented, you find yourself back in the portrait gallery.\n\n";
		}
		else
		{
			return "Talk to who?\n\n";
		}
	}
	
	public String get(String i)
	{
		if ((i.toLowerCase().contains("stick") || i.toLowerCase().contains("branch")) && ((GameState.roomX == GameState.stick1.locX && GameState.roomY == GameState.stick1.locY)))
		{
			GameState.stick1.locX = 100;
			GameState.stick1.locY = 100;
			return "Got the stick.\n\n";
		}
		else if ((i.toLowerCase().contains("stick") || i.toLowerCase().contains("branch")) && ((GameState.roomX == GameState.stick2.locX && GameState.roomY == GameState.stick2.locY)))
		{
			GameState.stick2.locX = 100;
			GameState.stick2.locY = 100;
			return "Got the stick.\n\n";
		}
		else
		{
			return "Get what?\n\n";
		}
	}
	
	public String inspect(String i)
	{
		if ((i.toLowerCase().contains("man") || i.toLowerCase().contains("hairy")) && GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "Hunched posture, protruding brow, and a startling profusion of body hair -- no doubt about it, you're looking at a bona fide caveman. He bangs two rocks together intently, seemingly vexed by the lack of results.\n\n";
		}
		else if ((i.toLowerCase().contains("stick") || i.toLowerCase().contains("branch")) && ((GameState.roomX == GameState.stick1.locX && GameState.roomY == GameState.stick1.locY) || GameState.stick1.locX == 100))
		{
			return GameState.stick1.desc;
		}
		else if ((i.toLowerCase().contains("stick") || i.toLowerCase().contains("branch")) && ((GameState.roomX == GameState.stick2.locX && GameState.roomY == GameState.stick2.locY) || GameState.stick2.locX == 100))
		{
			return GameState.stick2.desc;
		}
		else
		{
			return "Look at what?\n\n";
		}
	}

	public String getRoomDesc()
	{
		if (GameState.roomX == 0 && GameState.roomY == 0)
		{
			return "You stand amidst a barren prehistoric landscape strikingly similar to the one you'd seen in the painting. The air is humid and sulfurous, and the cries of some primordial creature echo in the distance. A cave carved into a nearby mountain lies to the north. To the west you see a small forest of strange-looking trees. The earth sinks into a deep ravine to the south.\n\n";
		}
		else if (GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "The cave is cool, damp, and mostly devoid of any objects of interest apart from a hairy, ape-like man squatting over what appears to be some kind of primitive fire pit. The cave's exit is to the south.\n\n";
		}
		else if (GameState.roomX == 0 && GameState.roomY == -1)
		{
			if (GameState.stick2.locX == 0 && GameState.stick2.locY == -1 && GameState.stick2.subGame == 1)
			{
				return "You carefully inch down into the ravine, wary of the crumbling rock faces that make up its walls. You are able to make it to the bottom, but your efforts go unrewarded: there isn't much to see down here short of a stick lying on the ground. The way back out of the ravine lies to the north.\n\n";
			}
			else
			{
				return "You carefully inch down into the ravine, wary of the crumbling rock faces that make up its walls. You are able to make it to the bottom, but your efforts go unrewarded: there isn't much to see down here. The way back out of the ravine lies to the north.\n\n";
			}
		}
		else if (GameState.roomX == -1 && GameState.roomY == 0)
		{
			if (GameState.stick1.locX == -1 && GameState.stick1.locY == 0 && GameState.stick1.subGame == 1)
			{
				return "The forest's trees are odd in appearance and gargantuan in size. The beastial noises you heard are louder here, making you uneasy. The forest's exist is to the east.\nYou see a stick on the ground here.\n\n";
			}
			else
			{
				return "The forest's trees are odd in appearance and gargantuan in size. The beastial noises you heard are louder here, making you uneasy. The forest's exist is to the east.\n\n";
			}
		}
		return null;
	}

}
