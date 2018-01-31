package edu.yccc.cis174.wlago.gettingstarted;

public class Object {
	
	private String name;
	private int id;
	private String message;
	
	Object()
	{
		
	}
	
	Object(String n, int i, String m)
	{
		this.name = n;
		this.id = i;
		this.message = m;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setId(int i)
	{
		this.id = i;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setMessage(String m)
	{
		this.message = m;
	}
	
	public String getMessage()
	{
		return this.message;
	}
	
}
