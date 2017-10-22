package Models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    Holds getters, setters and methods for accessing Quiz data
 */
public class Quiz implements SpecialEvent {

	private int id;
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;
	private int relatedFact;

	private Map<String,String> options = new HashMap<String,String>();

	
	public Quiz()
	{
		//There should be such a thing as an empty Quiz //todo
	}

	//Checks if answer is correct, returns true or false
	public boolean isCorrect(String answerIn){//should be a,b,c or d

        //If answer is correct
	    if (answerIn.equals(answer)){
	        return true;
        }
	    return false;
    }


	
	public String getAnswer()
	{
		return answer;
	}
	public String getOptions(){

		options.put("A", a);
		options.put("B", b);
		options.put("C", c);
		options.put("D", d);
	    return Arrays.toString(options.entrySet().toArray());
    }
	public String getOption(String option)
	{
		return options.get(option);
	}
	public int getRelatedFact()
	{
		return relatedFact;
	}

	public int getId()
	{
		return id;
	}
	public String getQuestion()
	{
		return question;
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


}
