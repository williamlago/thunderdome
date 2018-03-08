package edu.yccc.cis174.wlago.testinterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FillBlanks implements TestInterface
{
	public Scanner kb = new Scanner(System.in);
	private double questions = 0;
	private double correct = 0;
	
	public static void main(String[] args)
	{
		FillBlanks fb = new FillBlanks();
		ArrayList<Question> qs = new ArrayList<Question>();
		try
		{
			qs = fb.generateQuestions();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Welcome to the fill in the blanks test.\nEach correct answer will be only one word.\nPress enter to start.");
		fb.kb.nextLine();
		fb.start(qs);
	}
	
	public ArrayList<Question> generateQuestions() throws IOException
	{
		boolean nullLine = false;
		ArrayList<Question> qs = new ArrayList<Question>();
		BufferedReader qr = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\testinterface\\FBQuestions.txt"));
		BufferedReader ar = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\testinterface\\FBAnswers.txt"));
		while (nullLine == false)
		{
			String line = qr.readLine();
			if (line == null)
			{
				nullLine = true;
			}
			else
			{
				Question q = new Question();
				q.setQuestion(line);
				qs.add(q);
			}
		}
		qr.close();
		for (Question q : qs)
		{
			q.setAnswer(ar.readLine());
			questions++;
		}
		ar.close();	
		return qs;
	}
	
	public void start(ArrayList<Question> qs)
	{
		String input;
		
		for (Question q : qs)
		{
			System.out.println(q.getQuestion());
			input = kb.nextLine();
			if (input.toLowerCase().equals(q.getAnswer().toLowerCase()))
			{
				System.out.println("Correct!\n");
				correct++;
			}
			else
			{
				System.out.println("Incorrect... the answer was " + q.getAnswer() + ".\n");
			}
		}
		System.out.println("You have completed the test.\nYour final grade is " + grade() + "%.");
	}
	
	public double grade()
	{
		double grade = (correct / questions) * 100;
		return grade;
	}
}

