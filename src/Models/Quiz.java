package Models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
    Holds getters, setters and methods for accessing Quiz data
 */
public class Quiz implements QuizI {

	private int id;
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;
	private int relatedFact;

	private Map<String,String> options = new HashMap<String,String>();

	
	public Quiz() {
	}

	//Checks if answer is correct, returns true or false
	@Override
    public boolean isCorrect(String answerIn){//should be a,b,c or d

        //If answer is correct
	    if (answerIn.equals(answer)){
	        return true;
        }
	    return false;
    }


	
	@Override
    public String getAnswer()
	{
		return answer;
	}
	@Override
    public String getOptions(){

		options.put("A", a);
		options.put("B", b);
		options.put("C", c);
		options.put("D", d);
	    return Arrays.toString(options.entrySet().toArray());
    }
	@Override
    public void setId(int id) {
		this.id = id;
	}
	@Override
    public void setQuestion(String question) {
		this.question = question;
	}
	@Override
    public void setA(String a) {
		this.a = a;
	}
	@Override
    public void setB(String b) {
		this.b = b;
	}
	@Override
    public void setC(String c) {
		this.c = c;
	}
	@Override
    public void setD(String d) {
		this.d = d;
	}
	@Override
    public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
    public void setRelatedFact(int relatedFact) {
		this.relatedFact = relatedFact;
	}
	@Override
    public String getA() {
		return a;
	}
	@Override
    public String getB() {
		return b;
	}
	@Override
    public String getC() {
		return c;
	}
	@Override
    public String getD() {
		return d;
	}
    @Override
    public String getOption(String option)
    {
        return options.get(option);
    }
    @Override
    public int getRelatedFact()
    {
        return relatedFact;
    }
    @Override
    public int getId()
    {
        return id;
    }
    @Override
    public String getQuestion()
    {
        return question;
    }
}
