package Models;

import java.util.HashMap;
import java.util.Map;

public class Question {
	private int id;
	private String text;
	private Map<String,String> options = new HashMap<String,String>();
	private String answer;
	private int releventFact;
	
	public Question(int id,String text,String a,String b,String c,String d,String answer, int factId)
	{
		this.id = id;
		this.text = text;
		
		options.put("A", a);
		options.put("B", b);
		options.put("C", c);
		options.put("D", d);
		
		this.answer = answer;
		releventFact = factId;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getQuestion()
	{
		return text;
	}
	
	public String getOption(String option)
	{
		return options.get(option);
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public int getFact()
	{
		return releventFact;
	}
	
	
}
