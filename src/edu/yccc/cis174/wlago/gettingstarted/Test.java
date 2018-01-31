package edu.yccc.cis174.wlago.gettingstarted;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	/*
	 * Abstraction: The process of hiding the details of an implementation from the user; they will know what the object does, but not how it does it.
	 * Encapsulation: The usage specialized methods to retrieve and manipulate data from outside of an object's scope.
	 * Inheritance: The ability of a Java class to inherit fields and methods from a parent class.
	 * Polymorphism: The ability of Java objects to take on many forms, generally through multiple inheritance.
	 */
	
	public static void main (String[] args)
	{
		List<Object> objList = new ArrayList<Object>();
		Object obj = new Object("newObject", 1, "This is a sample object!");
		objList.add(obj);
		obj = new Object("newerObject", 2, "This is another sample object!");
		objList.add(obj);
		obj = new Object("newestObject", 3, "This is yet another sample object!");
		objList.add(obj);

		for(Object o : objList)
		{
			System.out.println(o.getName());
			System.out.println(o.getId());
			System.out.println(o.getMessage());
			System.out.println();
		}
		
		Subobject subObj = new Subobject("newSubObject", 4, "This object extends the sample object!", "This is a super special field only the subobject has!");
		System.out.println(subObj.getName());
		System.out.println(subObj.getId());
		System.out.println(subObj.getMessage());
		System.out.println(subObj.getSpecialField());
		
		return;
	}

}