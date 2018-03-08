package edu.yccc.cis174.wlago.testinterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice implements TestInterface
{
	public Scanner kb = new Scanner(System.in);
	private double questions = 0;
	private double correct = 0;
	
	public static void main(String[] args)
	{
		MultipleChoice mc = new MultipleChoice();
		ArrayList<Question> qs = new ArrayList<Question>();
		try
		{
			qs = mc.generateQuestions();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Welcome to the multiple choice test.\nWhen answering, enter only the letter of the correct answer.\nPress enter to start.");
		mc.kb.nextLine();
		mc.start(qs);
	}
	
	public ArrayList<Question> generateQuestions() throws IOException
	{
		boolean nullLine = false;
		ArrayList<Question> qs = new ArrayList<Question>();
		BufferedReader qr = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\testinterface\\MCQuestions.txt"));
		BufferedReader ar = new BufferedReader(new FileReader("src\\edu\\yccc\\cis174\\wlago\\testinterface\\MCAnswers.txt"));
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
				line = qr.readLine();
				q.setOptionA(line);
				line = qr.readLine();
				q.setOptionB(line);
				line = qr.readLine();
				q.setOptionC(line);
				line = qr.readLine();
				q.setOptionD(line);
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
			System.out.println(q.getOptionA());
			System.out.println(q.getOptionB());
			System.out.println(q.getOptionC());
			System.out.println(q.getOptionD());
			input = kb.nextLine();
			while (!input.toLowerCase().equals("a") && !input.toLowerCase().equals("b") && !input.toLowerCase().equals("c") && !input.toLowerCase().equals("d"))
			{
				System.out.println("Invalid answer. Please enter only the letter of the correct answer.");
				input = kb.nextLine();
			}
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
