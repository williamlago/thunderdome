package edu.yccc.cis174.wlago.javatest;

public class Question {
	
	private String question;
	private String answer;
	
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
}
