package edu.yccc.cis174.wlago.testinterface;

import java.io.IOException;
import java.util.ArrayList;

public interface TestInterface 
{
	
	ArrayList<Question> generateQuestions() throws IOException;
	void start(ArrayList<Question> q);
	double grade();

}
