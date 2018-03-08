package edu.yccc.cis174.wlago.testinterface;

public class Question 
{
	
	private String question;
	private String answer;
	private String optionA = null;
	private String optionB = null;
	private String optionC = null;
	private String optionD = null;
	
	Question()
	{
		this.question = "";
		this.answer = "";
	}
	
	Question(String q, String a)
	{
		this.question = q;
		this.answer = a;
	}
	
	public void setQuestion(String q)
	{
		this.question = q;
	}
	
	public String getQuestion()
	{
		return this.question;
	}
	
	public void setAnswer(String a)
	{
		this.answer = a;
	}
	
	public String getAnswer()
	{
		return this.answer;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) 
	{
		this.optionA = optionA;
	}

	public String getOptionB() 
	{
		return optionB;
	}

	public void setOptionB(String optionB) 
	{
		this.optionB = optionB;
	}

	public String getOptionC() 
	{
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() 
	{
		return optionD;
	}

	public void setOptionD(String optionD) 
	{
		this.optionD = optionD;
	}
}
