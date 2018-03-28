package edu.yccc.cis174.wlago.recursiondemo;

import java.io.File;

public class Recursive {
	
	int indent = 0;
		
	public void walkDir(String filePath)
	{
		//1. List files.
		//2. If a directory exists, call self.
		
		File f = new File(filePath);
		File[] files = f.listFiles();
		if (files != null)
		{
			for (int x = 0; x < (files.length); x++)
			{
				for (int n = 0; n < indent; n++)
				{
					System.out.print("    ");
				}
				System.out.println(files[x].getName());
				if (files[x].isDirectory())
				{
					indent++;
					walkDir(files[x].getAbsolutePath());
					indent--;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Recursive r = new Recursive();
		r.walkDir("C:\\");
	}

}
