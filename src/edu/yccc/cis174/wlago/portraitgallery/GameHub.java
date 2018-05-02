package edu.yccc.cis174.wlago.portraitgallery;

public class GameHub extends GameRules {
				
	public String start()
	{
		GameState.roomX = 0;
		GameState.roomY = 0;
		return "You awaken in a darkened portrait gallery with a splitting headache and a convenient case of amnesia that eliminates the need for actual exposition. All you can do now is try to find a way out...\n\n";
	}
	
	public String getRoomDesc()
	{
		if (GameState.roomX == 0 && GameState.roomY == 0)
		{
			return "You stand in a gloomy portrait hall. A heavy wooden door is set into the south wall, but it seems to be locked shut. A painting of a prehistoric landscape hangs on the west wall. A painting of a small frontier town hangs on the east wall. The hall continues to the north.\n\n";
		}
		else if (GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "The northern end of the portrait hall is just as dim and solemn as the southern end, though some light filters in through an ornate stained glass window on the northern wall. A painting of a castle hangs on the west wall. A painting of an unfamilar planet hangs on the east wall. The entrance to the gallery is back to the south.\n\n";
		}
		return null;
	}
	
	public String move(String i)
	{
		if (i.toLowerCase().equals("n") || i.toLowerCase().contains("north"))
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
		else if (i.toLowerCase().equals("s") || i.toLowerCase().contains("south"))
		{
			if (GameState.roomY == 1)
			{
				GameState.roomY--;
				return "You move south.\n\n" + getRoomDesc();
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
		return "Talk to who?\n\n";
	}
	
	public String get(String i)
	{
		return "Get what?\n\n";
	}

	public String inspect(String i)
	{
		if ((i.toLowerCase().contains("prehistoric") || i.toLowerCase().contains("landscape")) && GameState.roomX == 0 && GameState.roomY == 0)
		{
			if (GameState.finishedPrehistoric == false)
			{
				return "The landscape is primitive and desolate. For whatever reason, you feel a strong urge to touch the painting...\n\n";
			}
			else
			{
				return "The landscape is primitive and desolate. You can see light emanating from a cave in a distant mountain.\n\n";
			}
		}
		else if ((i.toLowerCase().contains("frontier") || i.toLowerCase().contains("town")) && GameState.roomX == 0 && GameState.roomY == 0)
		{
			return "A quaint, archetypal western town. The streets are empty. For whatever reason, you feel a strong urge to touch the painting...\n\n";
		}
		else if (!i.toLowerCase().contains("prehistoric") && !i.toLowerCase().contains("landscape") && !i.toLowerCase().contains("town") && !i.toLowerCase().contains("frontier") && i.toLowerCase().contains("painting") && GameState.roomX == 0 && GameState.roomY == 0)
		{
			return "Which painting, the painting of the prehistoric landscape or the painting of the frontier town?\n\n";
		}
		else if (i.toLowerCase().contains("door") && GameState.roomX == 0 && GameState.roomY == 0)
		{
			return "You do not see any kind of locking mechanism on the door, but despite your best efforts it won't budge.\n\n";
		}
		else if (i.toLowerCase().contains("planet") && GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "The planet is an otherworldly teal color, unlike any you've ever seen. For whatever reason, you feel a strong urge to touch the painting...\n\n";
		}
		else if (i.toLowerCase().contains("castle") && GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "The castle stands proudly amidst a dense forest. For whatever reason, you feel a strong urge to touch the painting...\n\n";
		}
		else if (!i.toLowerCase().contains("space") && !i.toLowerCase().contains("castle") && i.toLowerCase().contains("painting") && GameState.roomX == 0 && GameState.roomY == 1)
		{
			return "Which painting, the painting of the castle or the painting of the planet?\n\n";
		}
		else
		{
			return "Look at what?\n\n";
		}
	}
}
