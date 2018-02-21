package edu.yccc.cis174.wlago.javatest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JavaTest
{
	
	private Question[] questions = new Question[10];
	static Scanner kb = new Scanner(System.in);
	int correctQuestions = 0;
		
	public static void main(String[] args)
	{
		String input;
		System.out.println("Welcome to the Java Test!\nEnter any input to begin the test.");
		input = kb.nextLine();
		JavaTest test = new JavaTest();
		try
		{
			test.readQuestions();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
	
	public void readQuestions() throws IOException
	{
		int line = 0;
		BufferedReader qr = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\javatest\\questions.txt"));
		BufferedReader ar = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\javatest\\answers.txt"));
		try 
		{
			String str = qr.readLine();
			while (str != null)
			{
				questions[line] = new Question();
				questions[line].setQuestion(str);
				line++;
				str = qr.readLine();
			}
			str = ar.readLine();
			line = 0;
			while (str != null)
			{
				questions[line].setAnswer(str);
				line++;
				str = ar.readLine();
			}
		}
		finally
		{
			qr.close();
			ar.close();
			startTest();
		}
	}
	
	public void startTest()
	{
		int q = 0;
		String input = "";
		while (q < 10)
		{
			System.out.println(questions[q].getQuestion());
			input = kb.nextLine();
			if (input.toLowerCase().equals(questions[q].getAnswer()))
			{
				System.out.println("Correct!");
				correctQuestions++;
			}
			else
			{
				System.out.println(input);
				System.out.println("Incorrect... the correct answer was " + questions[q].getAnswer() + ".");
			}
			q++;
		}
		double score = calculateScore();
		System.out.println("You have finished the exam.\nYour score was " + score + "%.");
		try
		{
			writeScore();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
	
	public double calculateScore()
	{
		double score = 10 * correctQuestions;
		return score;
	}
	
	public void writeScore() throws IOException
	{
		try
		{
			Double score = calculateScore();
			String str = score.toString() + "%";
			BufferedWriter w = new BufferedWriter(new FileWriter("src\\edu\\yccc\\cis174\\wlago\\javatest\\score.txt"));
			w.write(str);
			w.close();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
	}
}
