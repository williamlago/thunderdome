package edu.yccc.cis174.wlago.portraitgallery;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameRules implements GameInterface 
{
	String roomDesc = new String();
	
	public String parse(String i)
	{
		if (i.toLowerCase().equals("look"))
		{
			return getRoomDesc();
		}
		else if (i.toLowerCase().charAt(0) == 'l' && i.toLowerCase().charAt(1) == 'o' && i.toLowerCase().charAt(2) == 'o' && i.toLowerCase().charAt(3) == 'k' && i.toLowerCase().charAt(4) == ' ')
		{
			return inspect(i);
		}
		else if (i.toLowerCase().contains("north") || i.toLowerCase().contains("south") || i.toLowerCase().contains("east") || i.toLowerCase().contains("west") || i.toLowerCase().equals("n") || i.toLowerCase().equals("s") || i.toLowerCase().equals("e") || i.toLowerCase().equals("w"))
		{
			return move(i);
		}
		else if (i.toLowerCase().contains("get") && i.toLowerCase().charAt(0) == 'g')
		{
			return get(i);
		}
		else if (i.toLowerCase().contains("touch") && GameState.subGame == 0)
		{
			if ((i.toLowerCase().contains("prehistoric") || i.toLowerCase().contains("landscape")) && GameState.roomX == 0 && GameState.roomY == 0)
			{
				if (GameState.finishedPrehistoric == false)
				{
					GameState.gp = new GamePrehistoric();
					GameState.subGame = 1;
					return GameState.gp.start() + GameState.gp.getRoomDesc();
				}
				else
				{
					return "Any magic the painting had seems to have been lost.\n\n";
				}
			}
			else if ((i.toLowerCase().contains("frontier") || i.toLowerCase().contains("town")) && GameState.roomX == 0 && GameState.roomY == 0 && GameState.finishedWestern == false)
			{
				return "You touch the painting, but nothing happens. Yet. Also, yeehaw.\n\n";
			}
			else if (i.toLowerCase().contains("planet") && GameState.roomX == 0 && GameState.roomY == 1 && GameState.finishedSpace == false)
			{
				return "You touch the painting, but nothing happens. Yet. Also, aliens.\n\n";
			}
			else if (i.toLowerCase().contains("castle") && GameState.roomX == 0 && GameState.roomY == 1)
			{
				if (GameState.finishedCastle == false)
				{
					GameState.gc = new GameCastle();
					GameState.subGame = 3;
					return GameState.gc.start() + GameState.gc.getRoomDesc();
				}
				else
				{
					return "Any magic the painting had seems to have been lost.\n\n";
				}
			}
			else
			{
				return "Unrecognized command.\n\n";
			}
		}
		else if (i.toLowerCase().contains("talk"))
		{
			return talk(i);
		}
		else if (i.toLowerCase().equals("inv") || i.toLowerCase().equals("inventory"))
		{
			return inventory();
		}
		else
		{
			return "Unrecognized command.\n\n";
		}
	}
	
	public String move(String i)
	{
		//override in child class
		return null;
	}
	
	public String inspect(String i)
	{
		//override in child class
		return null;
	}
	
	public String talk(String i)
	{
		//override in child class
		return null;
	}
	
	public String get(String i)
	{
		//override in child class
		return null;
	}
	
	public String inventory()
	{
		String inv = new String();
		if (GameState.stick1.locX == 100)
		{
			inv = inv + GameState.stick1.name + "\n";
		}
		if (GameState.stick2.locX == 100)
		{
			inv = inv + GameState.stick2.name + "\n";
		}
		if (GameState.candle.locX == 100)
		{
			inv = inv + GameState.candle.name + "\n";
		}
		if (inv.length() == 0)
		{
			inv = "nothing!\n";
		}
		inv = inv + "\n";
		return "You are currently carrying:\n" + inv;
	}
	
	public String getRoomDesc()
	{
		//override in child class
		return null;
	}
	
	public void save()
	{
		try {
            FileOutputStream file = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            GameState gs = new GameState();
            out.writeObject(gs);
            out.close();
            file.close();
            System.out.println("Serialized successfully."); 
        }
 
        catch (IOException ex) {
            System.out.println("IOException is caught.");
        }
	}
	
	public void load()
	{
		GameState gs = null;
		try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("save.ser");
            ObjectInputStream in = new ObjectInputStream(file);
             
            // Method for deserialization of object
            gs = (GameState)in.readObject();
            GameState.sync(gs);
             
            in.close();
            file.close();
             
            System.out.println("Object has been deserialized ");
            System.out.println("subGame = " + GameState.subGame);
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught.");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught.");
        }
	}
	
	public String help()
	{
		return "Type 'look' to survey your surroundings, or use the syntax 'look x' to examine specific objects.\nType 'north', 'south', 'east', or 'west' to move in that direction (if possible).\nType 'talk x' to interact with characters.\nType 'get x' to pick up items.\nType 'inventory' or 'inv' to see what items are currently in your possession.\n\n";
	}
	
	public void quit()
	{
		
	}
}
