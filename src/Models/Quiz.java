package Models;

import java.util.HashMap;
import java.util.Map;

public class Quiz {


	private int id;


	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;
	private int relatedFact;




	private int relevantFact;
	private String text;
	private Map<String,String> options = new HashMap<String,String>();

	
//	public Quiz(int id, String question, String a, String b, String c, String d, String answer, int factId)
//	{
//		this.id = id;
//		this.text = text;
//
//		options.put("A", a);
//		options.put("B", b);
//		options.put("C", c);
//		options.put("D", d);
//
//		this.answer = answer;
//		relevantFact = factId;
//	}
	
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
	
	public int getRelatedFact()
	{
		return relatedFact;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setA(String a) {
		this.a = a;
	}

	public void setB(String b) {
		this.b = b;
	}

	public void setC(String c) {
		this.c = c;
	}

	public void setD(String d) {
		this.d = d;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setRelatedFact(int relatedFact) {
		this.relatedFact = relatedFact;
	}

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}

	public String getD() {
		return d;
	}

	public int getRelevantFact() {
		return relevantFact;
	}

}
