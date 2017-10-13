package Models.Tests;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

import Models.Question;

public class QuestionTest {

	int id = 73;
	String text = "what is the answer?";
	String a = "A";	
	String b = "B";
	String c = "C";
	String d = "D";
	String answer = "C";
	int relevantId = 6;
	
	Question question = new Question (id,text,a,b,c,d,answer,relevantId);
	
	@Test 
	public void getId(){
		
		assertEquals(id,question.getId());
		
	}
	
	@Test
	public void getQuestion()
	{
		assertEquals(text,question.getQuestion());
	}
	
	@Test 
	public void getChoice()
	{
		assertEquals(a,question.getOption("A"));
	}
	
	@Test 
	public void getAnswer()
	{	assertEquals(answer,question.getAnswer());
		
	}
	
	@Test 
	public void getRelatedFact()
	{
		assertEquals(relevantId,question.getFact());
	}

}
