package edu.yccc.cis174.wlago.gettingstarted;

public class Subobject extends Object {
	
	String specialField;
	
	Subobject()
	{
		
	}
	
	Subobject(String n, int i, String m, String s)
	{
		this.setName(n);
		this.setId(i);
		this.setMessage(m);
		this.specialField = s;
	}
	
	public void setSpecialField(String s)
	{
		this.specialField = s;
	}
	
	public String getSpecialField()
	{
		return this.specialField;
	}

}
